package com.baharudin.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.baharudin.domain.model.MovieRemoteKeys

@Dao
interface MovieRemoteKeyDao {
    @Query("SELECT * FROM movie_remote_key WHERE id =:movieId")
    suspend fun getMovieRemoteKey(movieId : Int) : MovieRemoteKeys?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllMovieRemoteKey(movieRemoteKeys: List<MovieRemoteKeys>)

    @Query("DELETE FROM movie_remote_key")
    suspend fun deleteAllMovieRemoteKey()
}