package com.ashley.domain.usecases

import com.ashley.domain.MoviesCache
import com.ashley.domain.common.Transformer
import com.ashley.domain.entities.MovieEntity
import io.reactivex.Observable
import java.lang.IllegalArgumentException


class RemoveWatcListMovie(transformer: Transformer<Boolean>,
                          private val moviesCache: MoviesCache): UseCase<Boolean>(transformer) {

    companion object {
        private const val PARAM_MOVIE_ENTITY = "param:movieEntity"
    }

    fun remove(movieEntity: MovieEntity): Observable<Boolean> {
        val data = HashMap<String, MovieEntity>()
        data[PARAM_MOVIE_ENTITY] = movieEntity
        return observable(data)
    }

    override fun createObservable(data: Map<String, Any>?): Observable<Boolean> {

        val movieEntity = data?.get(PARAM_MOVIE_ENTITY)

        movieEntity?.let {
            return Observable.fromCallable {
                val entity = it as MovieEntity
                moviesCache.remove(entity)
                return@fromCallable false
            }
        }?: return Observable.error({ IllegalArgumentException("MovieEntity must be provided.") })
    }

}