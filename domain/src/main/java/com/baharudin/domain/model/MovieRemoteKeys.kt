package com.baharudin.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_remote_key")
data class MovieRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id : Int?,
    val prevPage : Int?,
    val nextPage : Int?,
    val lastUpdate : Long?
)