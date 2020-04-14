package com.ashley.peliculas.details

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.ashley.domain.common.Mapper
import com.ashley.domain.entities.MovieEntity
import com.ashley.domain.usecases.CheckFavoriteStatus
import com.ashley.domain.usecases.GetMovieDetails
import com.ashley.domain.usecases.RemoveFavoriteMovie
import com.ashley.domain.usecases.SaveFavoriteMovie
import com.ashley.peliculas.entities.Movie


class MovieDetailsVMFactory(
        private val getMovieDetails: GetMovieDetails,
        private val saveFavoriteMovie: SaveFavoriteMovie,
        private val removeFavoriteMovie: RemoveFavoriteMovie,
        private val checkFavoriteStatus: CheckFavoriteStatus,
        private val mapper: Mapper<MovieEntity, Movie>) : ViewModelProvider.Factory {

    var movieId: Int = -1

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieDetailsViewModel(
                getMovieDetails,
                saveFavoriteMovie,
                removeFavoriteMovie,
                checkFavoriteStatus,
                mapper,
                movieId) as T //TODO: solve casting issue
    }

}