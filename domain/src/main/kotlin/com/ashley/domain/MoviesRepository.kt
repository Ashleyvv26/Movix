package com.ashley.domain

import com.ashley.domain.entities.MovieEntity
import com.ashley.domain.entities.Optional
import io.reactivex.Observable

<<<<<<< HEAD

=======
/**
 * Created by Yossi Segev on 25/01/2018.
 */
>>>>>>> git3/master
interface MoviesRepository {
    fun getMovies(): Observable<List<MovieEntity>>
    fun search(query: String): Observable<List<MovieEntity>>
    fun getMovie(movieId: Int): Observable<Optional<MovieEntity>>
}