package com.ashley.data.repositories

import com.ashley.data.api.Api
import com.ashley.data.mappers.DetailsDataMovieEntityMapper
import com.ashley.data.mappers.MovieDataEntityMapper
import com.ashley.domain.MoviesDataStore
import com.ashley.domain.entities.MovieEntity
import com.ashley.domain.entities.Optional
import io.reactivex.Observable

class RemoteMoviesDataStore(private val api: Api) : MoviesDataStore {

    private val movieDataMapper = MovieDataEntityMapper()
    private val detailedDataMapper = DetailsDataMovieEntityMapper()

    override fun search(query: String): Observable<List<MovieEntity>> {
        return api.searchMovies(query).map { results ->
            results.movies.map { movieDataMapper.mapFrom(it) }
        }
    }

    override fun getMovies(): Observable<List<MovieEntity>> {
        return api.getPopularMovies().map { results ->
            results.movies.map { movieDataMapper.mapFrom(it) }
        }
    }

    override fun getMovieById(movieId: Int): Observable<Optional<MovieEntity>> {
        return api.getMovieDetails(movieId).flatMap { detailedData ->
            Observable.just(Optional.of(detailedDataMapper.mapFrom(detailedData)))
        }
    }
}