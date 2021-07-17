package com.droidkerala.theshard.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//data class for popular movies
@Parcelize
data class Movie(
     val id: String,
     val original_language: String,
     val original_title: String,
     val overview: String,
     val popularity: Double,
     val poster_path: String,
     val release_date: String,
     val title: String,
     val video: Boolean,
     val vote_average: String,
     val vote_count: String,
     val backdrop_path : String,
     val genre_ids: List<Int>
) : Parcelable