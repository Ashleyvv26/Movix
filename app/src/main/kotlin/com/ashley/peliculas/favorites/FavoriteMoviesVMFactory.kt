package com.ashley.peliculas.favorites

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.ashley.domain.common.Mapper
import com.ashley.domain.entities.MovieEntity
import com.ashley.domain.usecases.GetFavoriteMovies
import com.ashley.peliculas.entities.Movie


class FavoriteMoviesVMFactory(private val useCase: GetFavoriteMovies,
                              private val mapper: Mapper<MovieEntity, Movie>) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FavoriteMoviesViewModel(useCase, mapper) as T
    }

}