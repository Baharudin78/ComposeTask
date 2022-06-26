package com.baharudin.composetask.di

import android.app.Application
import androidx.room.Room
import com.baharudin.data.db.MovieDao
import com.baharudin.data.db.MovieDatabase
import com.baharudin.data.db.MovieRemoteKeyDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    fun provideDatabase(app : Application) : MovieDatabase =
        Room.databaseBuilder(app, MovieDatabase::class.java, "movie_db").fallbackToDestructiveMigration()
            .build()
    @Provides
    fun provideMovieDao(movieDb : MovieDatabase) : MovieDao = movieDb.movieDao()
    @Provides
    fun provideMovieRemoteKey(movieDb: MovieDatabase) : MovieRemoteKeyDao = movieDb.movieRemoteKeyDao()
}