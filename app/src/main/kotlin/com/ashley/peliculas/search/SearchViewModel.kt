package com.ashley.peliculas.search

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.ashley.domain.common.Mapper
import com.ashley.domain.entities.MovieEntity
import com.ashley.domain.usecases.SearchMovie
import com.ashley.peliculas.common.BaseViewModel
import com.ashley.peliculas.common.SingleLiveEvent
import com.ashley.peliculas.entities.Movie


class SearchViewModel(private val searchMovie: SearchMovie,
                      private val entityMovieMapper: Mapper<MovieEntity, Movie>) : BaseViewModel() {

    var viewState: MutableLiveData<SearchViewState> = MutableLiveData()
    var errorState: SingleLiveEvent<Throwable?> = SingleLiveEvent()

    init {
        viewState.value = SearchViewState()
    }

    fun search(query: String) {

        errorState.value = null

        if (query.isEmpty()) {
            viewState.value = viewState.value?.copy(
                    isLoading = false,
                    showNoResultsMessage = false,
                    lastSearchedQuery = query,
                    movies = null)
        } else {
            viewState.value = viewState.value?.copy(
                    isLoading = true,
                    showNoResultsMessage = false)

            performSearch(query)
        }
    }

    private fun performSearch(query: String) {
        Log.d(javaClass.simpleName, "Searching $query")

        addDisposable(searchMovie.search(query)
                .flatMap { entityMovieMapper.observable(it) }
                .subscribe({ movies ->
                    viewState.value = viewState.value?.copy(
                            isLoading = false,
                            movies = movies,
                            lastSearchedQuery = query,
                            showNoResultsMessage = movies.isEmpty())

                }, {
                    viewState.value = viewState.value?.copy(
                            isLoading = false,
                            movies = null,
                            lastSearchedQuery = query
                    )
                    errorState.value = it
                }))
    }


}