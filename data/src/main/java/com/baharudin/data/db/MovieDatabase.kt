package com.baharudin.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.baharudin.domain.model.Movie
import com.baharudin.domain.model.MovieRemoteKeys

@Database(
    entities = [Movie::class, MovieRemoteKeys::class],
    version = 1,
    exportSchema = false
)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao() : MovieDao
    abstract fun movieRemoteKeyDao() : MovieRemoteKeyDao
}