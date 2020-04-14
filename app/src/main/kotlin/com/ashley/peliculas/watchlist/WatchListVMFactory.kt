package com.ashley.peliculas.watchlist

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.ashley.domain.common.Mapper
import com.ashley.domain.entities.MovieEntity
import com.ashley.domain.usecases.GetWatchListMovies
import com.ashley.peliculas.entities.Movie


class WatchListVMFactory(private val useCase: GetWatchListMovies,
                         private val mapper: Mapper<MovieEntity, Movie>) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WatchListViewModel(useCase, mapper) as T
    }

}