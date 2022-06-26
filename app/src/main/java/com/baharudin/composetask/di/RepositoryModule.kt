package com.baharudin.composetask.di

import com.baharudin.data.repository.MovieRepositoryImpl
import com.baharudin.data.repository.datasource.MovieLocalDataSource
import com.baharudin.data.repository.datasource.MovieRemoteDataSource
import com.baharudin.data.repository.datasourceimpl.MovieRemoteDataSourceImpl
import com.baharudin.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource
    ) : MovieRepository =
        MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource
        )
}