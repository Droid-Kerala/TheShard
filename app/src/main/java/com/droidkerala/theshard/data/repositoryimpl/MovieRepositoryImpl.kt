package com.droidkerala.theshard.data.repositoryimpl

import com.droidkerala.theshard.data.MovieResponse
import com.droidkerala.theshard.data.datasources.MovieDataSource
import com.droidkerala.theshard.domain.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl@Inject constructor(
    private val movieDataSource: MovieDataSource
) : MovieRepository {


    override suspend fun getMovies(apiKey : String? , page :Int): MovieResponse {
      return  movieDataSource.getMoviesList(apiKey,page)
    }

}