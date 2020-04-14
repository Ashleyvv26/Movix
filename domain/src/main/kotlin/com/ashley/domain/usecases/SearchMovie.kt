package com.ashley.domain.usecases

import com.ashley.domain.MoviesRepository
import com.ashley.domain.common.Transformer
import com.ashley.domain.entities.MovieEntity
import io.reactivex.Observable

<<<<<<< HEAD
=======
/**
 * Created by Yossi Segev on 11/02/2018.
 */
>>>>>>> git3/master
class SearchMovie(transformer: Transformer<List<MovieEntity>>,
                  private val moviesRepository: MoviesRepository) : UseCase<List<MovieEntity>>(transformer) {

    companion object {
        private const val PARAM_SEARCH_QUERY = "param:search_query"
    }

    fun search(query: String): Observable<List<MovieEntity>> {
        val data = HashMap<String, String>()
        data[PARAM_SEARCH_QUERY] = query
        return observable(data)
    }

    override fun createObservable(data: Map<String, Any>?): Observable<List<MovieEntity>> {
        val query = data?.get(PARAM_SEARCH_QUERY)
        query?.let {
            return moviesRepository.search(it as String)
        } ?: return Observable.just(emptyList())
    }

}