package com.baharudin.data.api

import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/popular")
    suspend fun getPopularMovie(
        @Query(
            "api_key"
        ) apiKey : String,
        @Query("page")page : Int= 1
    )
}