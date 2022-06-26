package com.baharudin.domain.usecase

import com.baharudin.domain.repository.MovieRepository

class GetMoviePopularUseCase(
    private val movieRepository: MovieRepository
) {
    operator fun invoke() = movieRepository.getPopulatMovie()
}