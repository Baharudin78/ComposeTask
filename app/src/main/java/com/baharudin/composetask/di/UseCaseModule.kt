package com.baharudin.composetask.di

import com.baharudin.domain.repository.MovieRepository
import com.baharudin.domain.usecase.GetMovieFromLocalUseCase
import com.baharudin.domain.usecase.GetMoviePopularUseCase
import com.baharudin.domain.usecase.MovieUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideMovieUseCase(movieRepository: MovieRepository) = MovieUseCase(
        getMoviePopularUseCase = GetMoviePopularUseCase(movieRepository),
        getMovieFromLocalUseCase = GetMovieFromLocalUseCase(movieRepository)
    )
}