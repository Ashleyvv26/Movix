package com.ashley.domain.usecases

import com.ashley.domain.entities.MovieEntity
import com.ashley.domain.MoviesRepository
import com.ashley.domain.common.Transformer
import io.reactivex.Observable

<<<<<<< HEAD

=======
/**
 * Created by Yossi Segev on 11/11/2017.
 */
>>>>>>> git3/master
open class GetPopularMovies(transformer: Transformer<List<MovieEntity>>,
                            private val moviesRepository: MoviesRepository) : UseCase<List<MovieEntity>>(transformer) {
    override fun createObservable(data: Map<String, Any>?): Observable<List<MovieEntity>> {
        return moviesRepository.getMovies()
    }

}