package com.droidkerala.theshard.domain

import android.security.identity.ResultData
import com.droidkerala.theshard.data.MovieResponse

interface MovieRepository {

    suspend fun getMovies(apiKey : String? , page :Int): MovieResponse


}