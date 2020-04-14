package com.ashley.peliculas.popularmovies

import android.arch.lifecycle.MutableLiveData
import com.ashley.domain.common.Mapper
import com.ashley.domain.entities.MovieEntity
import com.ashley.domain.usecases.GetPopularMovies
import com.ashley.peliculas.common.BaseViewModel
import com.ashley.peliculas.common.SingleLiveEvent
import com.ashley.peliculas.entities.Movie



class PopularMoviesViewModel(private val getPopularMovies: GetPopularMovies,
                             private val movieEntityMovieMapper: Mapper<MovieEntity, Movie>) :
        BaseViewModel() {

    var viewState: MutableLiveData<PopularMoviesViewState> = MutableLiveData()
    var errorState: SingleLiveEvent<Throwable?> = SingleLiveEvent()

    init {
        viewState.value = PopularMoviesViewState()
    }

    fun getPopularMovies() {
        addDisposable(getPopularMovies.observable()
                .flatMap { movieEntityMovieMapper.observable(it) }
                .subscribe({ movies ->
                    viewState.value?.let {
                        val newState = this.viewState.value?.copy(showLoading = false, movies = movies)
                        this.viewState.value = newState
                        this.errorState.value = null
                    }

                }, {
                    viewState.value = viewState.value?.copy(showLoading = false)
                    errorState.value = it
                }))
    }
}