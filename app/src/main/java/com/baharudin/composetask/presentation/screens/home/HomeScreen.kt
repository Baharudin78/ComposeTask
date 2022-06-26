package com.baharudin.composetask.presentation.screens.home

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.baharudin.composetask.ui.theme.AppContentColor
import com.baharudin.composetask.ui.theme.AppThemeColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel : HomeViewModel = hiltViewModel()
) {
    val systemUIController = rememberSystemUiController()
    val systemBarColor = MaterialTheme.colors.AppThemeColor
    val allMovies = viewModel.getMoviePopular.invoke().collectAsLazyPagingItems()

    SideEffect {
        systemUIController.setStatusBarColor(
            color = systemBarColor
        )
    }
    Scaffold(
        backgroundColor = MaterialTheme.colors.AppThemeColor,
        contentColor = MaterialTheme.colors.AppContentColor,
        topBar = {
            HomeTopBar()
        },
        content = {
            MovieListContent(allMovies = allMovies, navController = navController )
        }
    )
}
