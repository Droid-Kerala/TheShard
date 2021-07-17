package com.droidkerala.theshard.data

//data class for movie api response
data class MovieResponse(
    val page: Int=0,
    val results: MutableList<Movie>,
    val total_pages: Int=0,
    val total_results: Int=0
)