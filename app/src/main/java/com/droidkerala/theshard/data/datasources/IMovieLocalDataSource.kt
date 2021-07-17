package com.droidkerala.theshard.data.datasources

import com.droidkerala.theshard.data.Movie
import com.droidkerala.theshard.data.MovieResponse

interface IMovieLocalDataSource {
    fun saveMovieList(movieList : List<Movie>)
    fun getMovieListDataById(id: String): Movie?
}