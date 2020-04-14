package com.ashley.peliculas.search

import com.ashley.peliculas.entities.Movie


data class SearchViewState(
        val isLoading: Boolean = false,
        val movies: List<Movie>? = null,
        val lastSearchedQuery: String? = null,
        val showNoResultsMessage: Boolean = false
)