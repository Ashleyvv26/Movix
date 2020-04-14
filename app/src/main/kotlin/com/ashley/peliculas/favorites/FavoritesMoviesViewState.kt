package com.ashley.peliculas.favorites

import com.ashley.peliculas.entities.Movie


data class FavoritesMoviesViewState(
        val isLoading: Boolean = true,
        val isEmpty: Boolean = true,
        val movies: List<Movie>? = null
)