package com.baharudin.data.db

import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.baharudin.domain.model.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovies(movies : List<Movie>)

    @Query("SELECT * FROM movies")
    fun getAllMovies() : PagingSource<Int, Movie>

    @Query("SELECT * FROM movies WHERE movieId =:movieId")
    fun getMovieById(movieId : Int) : Flow<Movie>

    @Query("DELETE FROM movies")
    suspend fun deleteMovie()
}