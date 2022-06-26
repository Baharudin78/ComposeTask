package com.baharudin.composetask.di

import com.baharudin.data.api.MovieApi
import com.baharudin.data.db.MovieDatabase
import com.baharudin.data.repository.datasource.MovieRemoteDataSource
import com.baharudin.data.repository.datasourceimpl.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Provides
    fun provideMovieRemoteDataSource(movieApi: MovieApi, movieDatabase: MovieDatabase) : MovieRemoteDataSource =
        MovieRemoteDataSourceImpl(movieApi, movieDatabase)
}