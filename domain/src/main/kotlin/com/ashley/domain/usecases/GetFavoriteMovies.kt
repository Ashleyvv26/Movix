package com.ashley.domain.usecases

import com.ashley.domain.MoviesCache
import com.ashley.domain.common.Transformer
import com.ashley.domain.entities.MovieEntity
import io.reactivex.Observable

class GetFavoriteMovies(transformer: Transformer<List<MovieEntity>>,
                        private val moviesCache: MoviesCache): UseCase<List<MovieEntity>>(transformer) {

    override fun createObservable(data: Map<String, Any>?): Observable<List<MovieEntity>> {
        return moviesCache.getAll()
    }

}