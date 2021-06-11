package com.droidkerala.theshard.data.network

import com.droidkerala.theshard.data.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @Headers("Accept: application/json")
    @GET("popular")
    suspend fun getMoviesList(@Query("api_key") apikey: String?, @Query("page") page: Int): MovieResponse
}