package com.baharudin.composetask.presentation.screens.details

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.baharudin.composetask.ui.theme.AppContentColor
import com.baharudin.composetask.ui.theme.AppThemeColor

@Composable
fun MovieDetailScreen(
    movieId : String,
    navController: NavHostController,
    viewModel : MovieDetailViewModel = hiltViewModel()
) {
    viewModel.getDetailMovie(movieId.toInt())
    val movieDetail by viewModel.selectMovie.collectAsState() 
    Scaffold(
        topBar = {
            MovieDetailTopBar(navController = navController)
        },
        contentColor = MaterialTheme.colors.AppContentColor,
        backgroundColor = MaterialTheme.colors.AppThemeColor,
        content = {
            movieDetail?.let { 
                MovieDetailContent(movie = it)
            }
        }
    ) 
}