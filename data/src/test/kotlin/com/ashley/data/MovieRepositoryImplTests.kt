package com.ashley.data

import com.ashley.data.api.Api
import com.ashley.data.api.MovieListResult
import com.ashley.data.mappers.DetailsDataMovieEntityMapper
import com.ashley.data.repositories.CachedMoviesDataStore
import com.ashley.data.repositories.MoviesRepositoryImpl
import com.ashley.data.repositories.RemoteMoviesDataStore
import com.ashley.data.utils.TestsUtils
import com.ashley.domain.MoviesRepository
import com.ashley.domain.common.DomainTestUtils.Companion.generateMovieEntityList
import com.ashley.domain.common.TestMoviesCache
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*


class MovieRepositoryImplTests {

    private val detailsDataMapper = DetailsDataMovieEntityMapper()
    private lateinit var api: Api
    private lateinit var movieCache: TestMoviesCache
    private lateinit var movieRepository: MoviesRepository

    @Before
    fun before() {
        api = mock(Api::class.java)
        movieCache = TestMoviesCache()
        val cachedMoviesDataStore = CachedMoviesDataStore(movieCache)
        val remoteMoviesDataStore = RemoteMoviesDataStore(api)
        movieRepository = MoviesRepositoryImpl(cachedMoviesDataStore, remoteMoviesDataStore)
    }

    @Test
    fun testWhenCacheIsNotEmptyGetMoviesReturnsCachedMovies() {

        movieCache.saveAll(generateMovieEntityList())
        movieRepository.getMovies().test()
                .assertComplete()
                .assertValue { movies -> movies.size == 5 }

        verifyZeroInteractions(api)
    }

    @Test
    fun testWhenCacheIsEmptyGetMoviesReturnsMoviesFromApi() {
        val movieListResult = MovieListResult()
        movieListResult.movies = TestsUtils.generateMovieDataList()
        `when`(api.getPopularMovies()).thenReturn(Observable.just(movieListResult))
        movieRepository.getMovies().test()
                .assertComplete()
                .assertValue { movies -> movies.size == 5 }
    }

    @Test
    fun testSearchReturnsExpectedResults() {
        val movieListResult = MovieListResult()
        movieListResult.movies = TestsUtils.generateMovieDataList()
        `when`(api.searchMovies("test query")).thenReturn(Observable.just(movieListResult))
        movieRepository.search("test query").test()
                .assertComplete()
                .assertValue { results -> results.size == 5 }

    }

    @Test
    fun testGetMovieByIdReturnedApiMovie() {
        val detailsData = TestsUtils.generateDetailsData(100)

        `when`(api.getMovieDetails(100)).thenReturn(Observable.just(detailsData))
        movieRepository.getMovie(100).test()
                .assertComplete()
                .assertValue { it.hasValue() && it.value == detailsDataMapper.mapFrom(detailsData) }
    }
}