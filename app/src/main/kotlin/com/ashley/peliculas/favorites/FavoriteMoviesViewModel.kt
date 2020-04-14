package com.ashley.peliculas.favorites

import android.arch.lifecycle.MutableLiveData
import com.ashley.domain.common.Mapper
import com.ashley.domain.entities.MovieEntity
import com.ashley.domain.usecases.GetFavoriteMovies
import com.ashley.peliculas.common.BaseViewModel
import com.ashley.peliculas.common.SingleLiveEvent
import com.ashley.peliculas.entities.Movie


class FavoriteMoviesViewModel(private val getFavoriteMovies: GetFavoriteMovies,
                              private val movieEntityMovieMapper: Mapper<MovieEntity, Movie>) : BaseViewModel() {

    var viewState: MutableLiveData<FavoritesMoviesViewState> = MutableLiveData()
    var errorState: SingleLiveEvent<Throwable?> = SingleLiveEvent()

    init {
        val viewState = FavoritesMoviesViewState()
        this.viewState.value = viewState
    }

    fun getFavorites() {
        getFavoriteMovies.observable()
                .flatMap { movieEntityMovieMapper.observable(it) }
                .subscribe({ movies ->
                    val newViewState = viewState.value?.copy(
                            isEmpty = movies.isEmpty(),
                            isLoading = false,
                            movies = movies)
                    viewState.value = newViewState
                    errorState.value = null

                }, {
                    viewState.value = viewState.value?.copy(isLoading = false, isEmpty = false)
                    errorState.value = it

                })
    }

}