package com.baharudin.data.repository.datasourceimpl

import androidx.paging.*
import com.baharudin.data.api.MovieApi
import com.baharudin.data.db.MovieDatabase
import com.baharudin.data.paging.MovieRemoteMediator
import com.baharudin.data.repository.datasource.MovieRemoteDataSource
import com.baharudin.domain.model.Movie
import kotlinx.coroutines.flow.Flow

class MovieRemoteDataSourceImpl(
    private var movieApi: MovieApi,
    private var movieDatabase : MovieDatabase
) : MovieRemoteDataSource {

    private val movieDao = movieDatabase.movieDao()

    @OptIn(ExperimentalPagingApi::class)
    override fun getPopularMovieFromServer(): Flow<PagingData<Movie>> {
        val pagingSourceFactory = { movieDao.getAllMovies() }
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = MovieRemoteMediator(
                movieApi,
                movieDatabase
            ),
            pagingSourceFactory = pagingSourceFactory,
        ).flow
    }
}