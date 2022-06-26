package com.baharudin.data.repository.datasource

import androidx.paging.PagingData
import com.baharudin.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRemoteDataSource {
    fun getPopularMovieFromServer() : Flow<PagingData<Movie>>
}