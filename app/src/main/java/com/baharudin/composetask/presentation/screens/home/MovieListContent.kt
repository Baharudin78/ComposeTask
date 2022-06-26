package com.baharudin.composetask.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.baharudin.composetask.BuildConfig
import com.baharudin.composetask.presentation.components.RatingComponent
import com.baharudin.composetask.presentation.navigation.Screen
import com.baharudin.composetask.ui.theme.ItemBackgroundColor
import com.baharudin.domain.model.Movie
import kotlin.jvm.internal.Intrinsics


@Composable
fun MovieListContent(allMovies: LazyPagingItems<Movie>, navController: NavHostController) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
    ) {
        items(
            items = allMovies,
            key = { movie ->
                movie.pk
            }
        ) { movie ->
            if (movie != null) {
                MovieListItem(movie = movie, navController = navController)
            }
        }
    }
}

@Composable
fun MovieListItem(movie : Movie, navController : NavHostController) {
    Card(modifier = Modifier
        .padding(top = 8.dp)
        .height(180.dp)
        .fillMaxWidth(),
        elevation = 4.dp,
        backgroundColor = MaterialTheme.colors.ItemBackgroundColor
    ) {
        Row (
            modifier = Modifier
                .height(IntrinsicSize.Max)
                .fillMaxWidth()
                .clickable {
                    navController.navigate(route = Screen.MovieDetail.passMovieId(movieId = movie.movieId.toString()))
                },
            verticalAlignment = Alignment.CenterVertically
        ){
            movie.posterPath?.let { 
                Image(
                    modifier = Modifier
                        .padding(
                            4.dp
                        )
                        .width(120.dp),
                    painter = rememberImagePainter(
                        data = BuildConfig.POSTER_URL + movie.posterPath, builder = {
                            crossfade(true)
                            scale(Scale.FILL)
                        }
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )
            }
            Column(
                modifier = Modifier
                    .padding(
                        end = 2.dp
                    )
                    .height(IntrinsicSize.Max)
            ) {
                movie.title?.let { 
                    Text(text = it, style = MaterialTheme.typography.body1)
                }
                Spacer(modifier = Modifier.heightIn(4.dp))
                movie.rating?.let { 
                    RatingComponent(rating = it)
                }
            }
        }
    }
}