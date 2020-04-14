package com.ashley.peliculas.common

import android.app.Application
import com.squareup.leakcanary.LeakCanary
import com.ashley.peliculas.R
import com.ashley.peliculas.di.*
import com.ashley.peliculas.di.watchList.WatchListMoviesModule
import com.ashley.peliculas.di.watchList.WatchListSubComponent
import com.ashley.peliculas.di.details.MovieDetailsModule
import com.ashley.peliculas.di.details.MovieDetailsSubComponent
import com.ashley.peliculas.di.favorites.FavoriteModule
import com.ashley.peliculas.di.favorites.FavoritesSubComponent
import com.ashley.peliculas.di.modules.*
import com.ashley.peliculas.di.popular.PopularMoviesModule
import com.ashley.peliculas.di.popular.PopularSubComponent
import com.ashley.peliculas.di.search.SearchMoviesModule
import com.ashley.peliculas.di.search.SearchSubComponent


class App: Application() {

    lateinit var mainComponent: MainComponent
    private var popularMoviesComponent: PopularSubComponent? = null
    private var favoriteMoviesComponent: FavoritesSubComponent? = null
    private var watchListMoviesComponent: WatchListSubComponent? = null
    private var movieDetailsComponent: MovieDetailsSubComponent? = null
    private var searchMoviesComponent: SearchSubComponent? = null

    override fun onCreate() {
        super.onCreate()

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        LeakCanary.install(this)

        initDependencies()
    }

    private fun initDependencies() {
        mainComponent = DaggerMainComponent.builder()
                .appModule(AppModule(applicationContext))
                .networkModule(NetworkModule(getString(R.string.api_base_url), getString(R.string.api_key)))
                .dataModule(DataModule())
                .build()

    }

    fun createPopularComponenet(): PopularSubComponent {
        popularMoviesComponent = mainComponent.plus(PopularMoviesModule())
        return popularMoviesComponent!!
    }
    fun releasePopularComponent() {
        popularMoviesComponent = null
    }

    fun createFavoritesComponent() : FavoritesSubComponent {
        favoriteMoviesComponent = mainComponent.plus(FavoriteModule())
        return favoriteMoviesComponent!!
    }

    fun releaseFavoritesComponent() {
        favoriteMoviesComponent = null
    }

    fun createWatchListComponent() : WatchListSubComponent {
        watchListMoviesComponent = mainComponent.plus(WatchListMoviesModule())
        return watchListMoviesComponent!!
    }

    fun releaseWatchListComponent() {
        watchListMoviesComponent = null
    }

    fun createDetailsComponent(): MovieDetailsSubComponent {
        movieDetailsComponent = mainComponent.plus(MovieDetailsModule())
        return movieDetailsComponent!!
    }
    fun releaseDetailsComponent() {
        movieDetailsComponent = null
    }

    fun createSearchComponent(): SearchSubComponent {
        searchMoviesComponent = mainComponent.plus(SearchMoviesModule())
        return searchMoviesComponent!!
    }
    fun releaseSearchComponent() {
        searchMoviesComponent = null
    }
}