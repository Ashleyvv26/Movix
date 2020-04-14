package com.ashley.peliculas.search

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.ashley.domain.common.Mapper
import com.ashley.domain.entities.MovieEntity
import com.ashley.domain.usecases.SearchMovie
import com.ashley.peliculas.entities.Movie


class SearchVMFactory(val searchMovie: SearchMovie,
                       val mapper: Mapper<MovieEntity, Movie>): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SearchViewModel(searchMovie, mapper) as T
    }

}