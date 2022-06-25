package com.baharudin.domain.repository

import androidx.paging.PagingData
import com.baharudin.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getPopulatMovie() : Flow<PagingData<Movie>>
    fun getPopularMovie(movieId : String) : Flow<Movie>
}