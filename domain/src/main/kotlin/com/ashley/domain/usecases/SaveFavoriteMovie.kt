package com.ashley.domain.usecases

import com.ashley.domain.MoviesCache
import com.ashley.domain.common.Transformer
import com.ashley.domain.entities.MovieEntity
import io.reactivex.Observable
import java.lang.IllegalArgumentException

<<<<<<< HEAD

=======
/**
 * Created by Yossi Segev on 21/01/2018.
 */
>>>>>>> git3/master
class SaveFavoriteMovie(transformer: Transformer<Boolean>,
                        private val moviesCache: MoviesCache): UseCase<Boolean>(transformer) {

    companion object {
        private const val PARAM_MOVIE_ENTITY = "param:movieEntity"
    }

    override fun createObservable(data: Map<String, Any>?): Observable<Boolean> {

        val movieEntity = data?.get(PARAM_MOVIE_ENTITY)

        movieEntity?.let {
            return Observable.fromCallable {
                val entity = it as MovieEntity
                moviesCache.save(entity)
                return@fromCallable true
            }
        }?: return Observable.error({ IllegalArgumentException("MovieEntity must be provided.") })

    }

    fun save(movieEntity: MovieEntity): Observable<Boolean> {
        val data = HashMap<String, MovieEntity>()
        data[PARAM_MOVIE_ENTITY] = movieEntity
        return observable(data)
    }
}