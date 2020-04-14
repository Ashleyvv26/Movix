package com.ashley.peliculas.popularmovies

import com.ashley.peliculas.entities.Movie


data class PopularMoviesViewState(
        var showLoading: Boolean = true,
        var movies: List<Movie>? = null
)
