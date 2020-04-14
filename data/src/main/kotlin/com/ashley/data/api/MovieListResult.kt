package com.ashley.data.api

import com.google.gson.annotations.SerializedName
import com.ashley.data.entities.MovieData


class MovieListResult {

    var page: Int = 0
    @SerializedName("results")
    lateinit var movies: List<MovieData>
}