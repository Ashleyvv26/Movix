package com.ashley.domain

import com.ashley.domain.entities.MovieEntity
import com.ashley.domain.entities.Optional
import io.reactivex.Observable


interface MoviesRepository {
    fun getMovies(): Observable<List<MovieEntity>>
    fun search(query: String): Observable<List<MovieEntity>>
    fun getMovie(movieId: Int): Observable<Optional<MovieEntity>>
}