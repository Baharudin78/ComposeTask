package com.baharudin.composetask.presentation.navigation

sealed class Screen(val route : String) {
    object Home : Screen("home_screen")
    object MovieDetail : Screen("movie_detail_screen/{movieId}") {
        fun passMovieId(movieId : String) = "movie_detail_screen/$movieId"
    }
}
