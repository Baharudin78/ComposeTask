package com.baharudin.domain.usecase

import com.baharudin.domain.repository.MovieRepository

class GetMovieFromLocalUseCase(
    private val movieRepository: MovieRepository
    ) {
    operator fun invoke(movieId : Int) = movieRepository.getPopularMovie(movieId)
}