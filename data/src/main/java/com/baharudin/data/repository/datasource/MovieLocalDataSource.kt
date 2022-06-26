package com.baharudin.data.repository.datasource

import com.baharudin.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieLocalDataSource {
    fun getMovieFromDB(movieId : Int) : Flow<Movie>
}