package com.baharudin.data.api

import com.baharudin.domain.model.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/popular")
    suspend fun getPopularMovie(
        @Query(
            "api_key"
        ) apiKey : String,
        @Query("page")page : Int= 1
    ) : Response<MovieList>
}