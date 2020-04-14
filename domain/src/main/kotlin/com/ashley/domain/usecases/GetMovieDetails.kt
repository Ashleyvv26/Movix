package com.ashley.domain.usecases

import com.ashley.domain.MoviesRepository
import com.ashley.domain.common.Transformer
import com.ashley.domain.entities.MovieEntity
import com.ashley.domain.entities.Optional
import io.reactivex.Observable
import java.lang.IllegalArgumentException

<<<<<<< HEAD

=======
/**
 * Created by Yossi Segev on 11/11/2017.
 */
>>>>>>> git3/master
class GetMovieDetails(
        transformer: Transformer<Optional<MovieEntity>>,
        private val moviesRepository: MoviesRepository) : UseCase<Optional<MovieEntity>>(transformer) {

    companion object {
        private const val PARAM_MOVIE_ENTITY = "param:movieEntity"
    }

    fun getById(movieId: Int): Observable<Optional<MovieEntity>> {
        val data = HashMap<String, Int>()
        data[PARAM_MOVIE_ENTITY] = movieId
        return observable(data)
    }

    override fun createObservable(data: Map<String, Any>?): Observable<Optional<MovieEntity>> {
        val movieId = data?.get(PARAM_MOVIE_ENTITY)
        movieId?.let {
            return moviesRepository.getMovie(it as Int)
        } ?: return Observable.error({ IllegalArgumentException("MovieId must be provided.") })
    }
}