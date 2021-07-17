package com.droidkerala.theshard.data.datasources

import com.droidkerala.theshard.data.MovieResponse
import com.droidkerala.theshard.data.network.ApiService
import retrofit2.http.Query
import javax.inject.Inject

interface IMovieDataSource  {

    suspend fun getMoviesList(apikey: String?, page: Int) : MovieResponse

}