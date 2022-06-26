package com.baharudin.domain.usecase

data class MovieUseCase(
    val getMoviePopularUseCase : GetMoviePopularUseCase,
    val getMovieFromLocalUseCase: GetMovieFromLocalUseCase
)