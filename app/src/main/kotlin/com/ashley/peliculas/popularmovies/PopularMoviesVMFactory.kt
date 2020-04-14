package com.ashley.peliculas.popularmovies

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.ashley.domain.common.Mapper
import com.ashley.domain.entities.MovieEntity
import com.ashley.domain.usecases.GetPopularMovies
import com.ashley.peliculas.entities.Movie


class PopularMoviesVMFactory(private val useCase: GetPopularMovies,
                             private val mapper: Mapper<MovieEntity, Movie>) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PopularMoviesViewModel(useCase, mapper) as T
    }

}