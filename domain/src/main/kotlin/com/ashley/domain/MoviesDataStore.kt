package com.ashley.domain

import com.ashley.domain.entities.MovieEntity
import com.ashley.domain.entities.Optional
import io.reactivex.Observable


interface MoviesDataStore {

    fun getMovieById(movieId: Int): Observable<Optional<MovieEntity>>
    fun getMovies(): Observable<List<MovieEntity>>
    fun search(query: String): Observable<List<MovieEntity>>
}