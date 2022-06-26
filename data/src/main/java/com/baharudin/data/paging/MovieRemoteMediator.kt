package com.baharudin.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.baharudin.data.BuildConfig
import com.baharudin.data.api.MovieApi
import com.baharudin.data.db.MovieDao
import com.baharudin.data.db.MovieDatabase
import com.baharudin.domain.model.Movie
import com.baharudin.domain.model.MovieRemoteKeys

@OptIn(ExperimentalPagingApi::class)
class MovieRemoteMediator(
    private val movieApi : MovieApi, private val movieDb : MovieDatabase
    ) : RemoteMediator<Int, Movie>() {

    private val movieDao = movieDb.movieDao()
    private val movieRemoteKeysDao = movieDb.movieRemoteKeyDao()
    override suspend fun load(loadType: LoadType, state: PagingState<Int, Movie>): MediatorResult {

        return try {
            val page = when(loadType) {
                LoadType.REFRESH -> {
                    val remoteKey = getRemoteKeyClosesToCurrentPossition(state)
                    remoteKey?.nextPage?.minus(1) ?: 1
                }
                LoadType.PREPEND -> {
                    val remoteKey = getRemoteKeyForFirstItem(state)
                    val prevPage = remoteKey?.prevPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKey != null
                        )
                    prevPage
                }
                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKeys?.nextPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    nextPage
                }
            }
            val response = movieApi.getPopularMovie(apiKey = BuildConfig.API_KEY, page = page)
            var endPaginationReached = false
            if (response.isSuccessful) {
                val responseData = response.body()
                endPaginationReached = responseData == null
                responseData?.let {
                    movieDb.withTransaction {
                        if (loadType == LoadType.REFRESH) {
                            movieDao.deleteMovie()
                            movieRemoteKeysDao.deleteAllMovieRemoteKey()
                        }
                        var prevPage : Int?
                        var nextPage : Int

                        responseData.page.let { pageNumber ->
                            nextPage = pageNumber + 1
                            prevPage = if (pageNumber <= 1) null else pageNumber - 1
                        }

                        val keys = responseData.movies.map { movie ->
                            MovieRemoteKeys(
                                id = movie.movieId,
                                prevPage = prevPage,
                                nextPage = nextPage,
                                lastUpdate = System.currentTimeMillis()
                            )
                        }
                        movieRemoteKeysDao.addAllMovieRemoteKey(movieRemoteKeys = keys)
                        movieDao.addMovies(movies = responseData.movies)
                    }
                }
            }
            MediatorResult.Success(endOfPaginationReached = endPaginationReached)
        }catch (e : Exception) {
            return MediatorResult.Error(e)
        }
    }

    private suspend fun getRemoteKeyClosesToCurrentPossition(
        state: PagingState<Int, Movie>
    ) : MovieRemoteKeys?{
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.movieId?.let { id ->
                movieRemoteKeysDao.getMovieRemoteKey(movieId = id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(
        state: PagingState<Int, Movie>
    ) : MovieRemoteKeys? {
        return state.pages.firstOrNull {
            it.data.isNotEmpty()
        }?.data?.firstOrNull()
            ?.let { movie ->
                movieRemoteKeysDao.getMovieRemoteKey(movieId = movie.movieId)
            }
    }

    private suspend fun getRemoteKeyForLastItem(
        state: PagingState<Int, Movie>
    ) : MovieRemoteKeys? {
        return state.pages.lastOrNull {
            it.data.isNotEmpty()
        }?.data?.lastOrNull()
            ?.let { movie ->
                movieRemoteKeysDao.getMovieRemoteKey(movieId = movie.movieId)
            }
    }

}