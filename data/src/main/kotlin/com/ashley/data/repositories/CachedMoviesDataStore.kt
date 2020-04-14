package com.ashley.data.repositories

import com.ashley.domain.MoviesCache
import com.ashley.domain.MoviesDataStore
import com.ashley.domain.entities.MovieEntity
import com.ashley.domain.entities.Optional
import io.reactivex.Observable


class CachedMoviesDataStore(private val moviesCache: MoviesCache): MoviesDataStore {

    override fun search(query: String): Observable<List<MovieEntity>> {
        return moviesCache.search(query)
    }

    override fun getMovieById(movieId: Int): Observable<Optional<MovieEntity>> {
        return moviesCache.get(movieId)
    }

    override fun getMovies(): Observable<List<MovieEntity>> {
        return moviesCache.getAll()
    }

    fun isEmpty(): Observable<Boolean> {
        return moviesCache.isEmpty()
    }

    fun saveAll(movieEntities: List<MovieEntity>) {
        moviesCache.saveAll(movieEntities)
    }
}