package com.ashley.peliculas.watchlist

import android.arch.lifecycle.MutableLiveData
import com.ashley.domain.common.Mapper
import com.ashley.domain.entities.MovieEntity
import com.ashley.domain.usecases.GetWatchListMovies
import com.ashley.peliculas.common.BaseViewModel
import com.ashley.peliculas.common.SingleLiveEvent
import com.ashley.peliculas.entities.Movie


class WatchListViewModel(private val getWatchListMovies: GetWatchListMovies,
                         private val movieEntityMovieMapper: Mapper<MovieEntity, Movie>) : BaseViewModel() {

    var viewState: MutableLiveData<WatchListViewState> = MutableLiveData()
    var errorState: SingleLiveEvent<Throwable?> = SingleLiveEvent()

    init {
        val viewState = WatchListViewState()
        this.viewState.value = viewState
    }

    fun getWatchList() {
        getWatchListMovies.observable()
                .flatMap { movieEntityMovieMapper.observable(it) }
                .subscribe({ movies ->
                    val newViewState = viewState.value?.copy(
                            isEmpty = movies.isEmpty(),
                            isLoading = false,
                            moviesw = movies)
                    viewState.value = newViewState
                    errorState.value = null

                }, {
                    viewState.value = viewState.value?.copy(isLoading = false, isEmpty = false)
                    errorState.value = it

                })
    }

}