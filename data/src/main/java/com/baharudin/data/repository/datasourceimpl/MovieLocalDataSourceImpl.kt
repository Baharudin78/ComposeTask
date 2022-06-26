package com.baharudin.data.repository.datasourceimpl

import com.baharudin.data.db.MovieDao
import com.baharudin.data.repository.datasource.MovieLocalDataSource
import com.baharudin.domain.model.Movie
import kotlinx.coroutines.flow.Flow

class MovieLocalDataSourceImpl(
    private var movieDao: MovieDao
    ) : MovieLocalDataSource {
    override fun getMovieFromDB(movieId: Int): Flow<Movie> {
        return movieDao.getMovieById(movieId)
    }
}