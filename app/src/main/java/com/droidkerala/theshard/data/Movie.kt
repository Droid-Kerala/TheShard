/*
 * Copyright (c) 10/01/2019
 * Author : DroidFreak
 */

package com.droidkerala.theshard.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

//data class for popular movies
@Parcelize
@Entity(tableName = "movies")
data class Movie(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "original_language") val original_language: String,
    @ColumnInfo(name = "original_title") val original_title: String,
    @ColumnInfo(name = "overview") val overview: String,
    @ColumnInfo(name = "popularity") val popularity: Double,
    @ColumnInfo(name = "poster_path") val poster_path: String,
    @ColumnInfo(name = "release_date") val release_date: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "video") val video: Boolean,
    @ColumnInfo(name = "vote_average") val vote_average: String,
    @ColumnInfo(name = "vote_count") val vote_count: String
) : Parcelable