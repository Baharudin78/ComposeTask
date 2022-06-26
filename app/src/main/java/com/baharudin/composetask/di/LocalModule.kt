package com.baharudin.composetask.di

import com.baharudin.data.db.MovieDao
import com.baharudin.data.repository.datasource.MovieLocalDataSource
import com.baharudin.data.repository.datasourceimpl.MovieLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    fun provideLocalDataSource(movieDao: MovieDao) : MovieLocalDataSource =
        MovieLocalDataSourceImpl(movieDao)
}