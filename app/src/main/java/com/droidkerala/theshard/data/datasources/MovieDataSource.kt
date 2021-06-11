package com.droidkerala.theshard.data.datasources

import com.droidkerala.theshard.data.MovieResponse
import com.droidkerala.theshard.data.network.ApiService
import retrofit2.http.Query
import javax.inject.Inject

class MovieDataSource @Inject constructor(private  val apiService: ApiService){

    suspend fun getMoviesList(apikey: String?, page: Int) = apiService.getMoviesList(apikey,page)

}