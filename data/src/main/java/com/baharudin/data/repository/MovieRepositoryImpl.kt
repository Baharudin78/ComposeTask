package com.baharudin.data.repository

import androidx.paging.PagingData
import com.baharudin.data.repository.datasource.MovieLocalDataSource
import com.baharudin.data.repository.datasource.MovieRemoteDataSource
import com.baharudin.domain.model.Movie
import com.baharudin.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource
) : MovieRepository{
    override fun getPopulatMovie(): Flow<PagingData<Movie>> =
         movieRemoteDataSource.getPopularMovieFromServer()

    override fun getPopularMovie(movieId: Int): Flow<Movie> =
        movieLocalDataSource.getMovieFromDB(movieId)

}