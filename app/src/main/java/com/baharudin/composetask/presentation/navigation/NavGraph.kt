package com.baharudin.composetask.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.baharudin.composetask.presentation.screens.details.MovieDetailScreen
import com.baharudin.composetask.presentation.screens.home.HomeScreen
import com.baharudin.composetask.utils.Constants

@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController ,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navHostController)
        }
        composable(
            route = Screen.MovieDetail.route,
            arguments = listOf(navArgument(Constants.MOVIE_DETAILS_ARGUMENT_KEY) {
                type = NavType.StringType
            })
        ) { navBackStackEntry ->
            navBackStackEntry.arguments?.getString(Constants.MOVIE_DETAILS_ARGUMENT_KEY)
                ?.let {
                    MovieDetailScreen(movieId = it, navController = navHostController )
                }
        }
    }
}