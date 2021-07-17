package com.droidkerala.theshard.data.repositoryimpl

import com.droidkerala.theshard.data.Movie
import com.droidkerala.theshard.data.MovieResponse
import com.droidkerala.theshard.data.datasources.IMovieDataSource
import com.droidkerala.theshard.data.datasources.IMovieLocalDataSource
import com.droidkerala.theshard.data.datasources.MovieDataSource
import com.droidkerala.theshard.data.datasources.MovieLocalDataSource
import com.droidkerala.theshard.domain.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieDataSource: IMovieDataSource,
    private val movieLocalDataSource: IMovieLocalDataSource
) : MovieRepository {


    override suspend fun getMovies(apiKey: String?, page: Int): MovieResponse {
        val list = movieDataSource.getMoviesList(apiKey, page)
        movieLocalDataSource.saveMovieList(list.results)
        return list
    }

    override fun getMovieListById(id: String): Movie? {
        return movieLocalDataSource.getMovieListDataById(id)
    }

}