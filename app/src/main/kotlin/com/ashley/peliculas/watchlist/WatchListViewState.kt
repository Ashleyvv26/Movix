package com.ashley.peliculas.watchlist

import com.ashley.peliculas.entities.Movie

data class WatchListViewState(
        val isLoading: Boolean = true,
        val isEmpty: Boolean = true,
        val moviesw: List<Movie>? = null
)