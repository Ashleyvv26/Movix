package com.ashley.peliculas

import android.arch.lifecycle.Observer
import android.support.test.annotation.UiThreadTest
import android.support.test.runner.AndroidJUnit4
import com.ashley.domain.MoviesCache
import com.ashley.domain.common.DomainTestUtils
import com.ashley.domain.common.TestTransformer
import com.ashley.domain.usecases.GetFavoriteMovies
import com.ashley.peliculas.favorites.FavoriteMoviesViewModel
import com.ashley.peliculas.favorites.FavoritesMoviesViewState
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*

@Suppress("UNCHECKED_CAST")
@RunWith(AndroidJUnit4::class)
class FavoriteMoviesViewModelTests {

    private val movieEntityMovieMapper = MovieEntityMovieMapper()
    private lateinit var favoriteMoviesViewModel: FavoriteMoviesViewModel
    private lateinit var moviesCache: MoviesCache
    private lateinit var viewObserver: Observer<FavoritesMoviesViewState>
    private lateinit var errorObserver: Observer<Throwable?>

    @Before
    @UiThreadTest
    fun before() {
        moviesCache = mock(MoviesCache::class.java)
        val getFavoriteMovies = GetFavoriteMovies(TestTransformer(), moviesCache)
        favoriteMoviesViewModel = FavoriteMoviesViewModel(getFavoriteMovies, movieEntityMovieMapper)
        viewObserver = mock(Observer::class.java) as Observer<FavoritesMoviesViewState>
        errorObserver = mock(Observer::class.java) as Observer<Throwable?>
        favoriteMoviesViewModel.viewState.observeForever(viewObserver)
        favoriteMoviesViewModel.errorState.observeForever(errorObserver)
    }

    @Test
    @UiThreadTest
    fun testInitialViewStateShowsLoading() {
        verify(viewObserver).onChanged(FavoritesMoviesViewState(isLoading = true, isEmpty = true, movies = null))
        verifyZeroInteractions(errorObserver)
    }

    @Test
    @UiThreadTest
    fun testShowingMoviesAsExpectedAndStopsLoading() {
        val movieEntities = DomainTestUtils.generateMovieEntityList()
        `when`(moviesCache.getAll()).thenReturn(Observable.just(movieEntities))
        val movies = movieEntities.map { movieEntityMovieMapper.mapFrom(it) }
        favoriteMoviesViewModel.getFavorites()

        verify(viewObserver).onChanged(FavoritesMoviesViewState(isLoading = false, isEmpty = false, movies = movies))
        verify(errorObserver).onChanged(null)
    }

    @Test
    @UiThreadTest
    fun testShowingEmptyMessage() {
        `when`(moviesCache.getAll()).thenReturn(Observable.just(mutableListOf()))
        favoriteMoviesViewModel.getFavorites()

        verify(viewObserver).onChanged(FavoritesMoviesViewState(isLoading = false, isEmpty = true, movies = mutableListOf()))
        verify(errorObserver).onChanged(null)
    }

    @Test
    @UiThreadTest
    fun testShowingErrorWhenNeeded() {
        val throwable = Throwable("ERROR!")
        `when`(moviesCache.getAll()).thenReturn(Observable.error(throwable))
        favoriteMoviesViewModel.getFavorites()

        verify(viewObserver).onChanged(FavoritesMoviesViewState(isLoading = false, isEmpty = false, movies = null))
        verify(errorObserver).onChanged(throwable)
    }
}
