package com.ashley.domain

import com.ashley.domain.entities.MovieEntity
import com.ashley.domain.entities.Optional
import io.reactivex.Observable

/**
 * Created by Yossi Segev on 21/01/2018.
 */
interface MoviesCache {

    fun clear()
    fun save(movieEntity: MovieEntity)
    fun remove(movieEntity: MovieEntity)
    fun saveAll(movieEntities: List<MovieEntity>)
    fun getAll(): Observable<List<MovieEntity>>
    fun get(movieId: Int): Observable<Optional<MovieEntity>>
    fun search(query: String): Observable<List<MovieEntity>>
    fun isEmpty(): Observable<Boolean>
}