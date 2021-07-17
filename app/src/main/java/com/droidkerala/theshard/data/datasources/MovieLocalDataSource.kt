package com.droidkerala.theshard.data.datasources

import com.droidkerala.theshard.data.Movie
import javax.inject.Inject

class MovieLocalDataSource @Inject constructor() : IMovieLocalDataSource {
    private var listMovieData: List<Movie>? = null
    override fun saveMovieList(movieList: List<Movie>) {
        this.listMovieData = movieList
    }

    override fun getMovieListDataById(id: String): Movie? {
        return listMovieData?.firstOrNull { it.id == id }
    }
}