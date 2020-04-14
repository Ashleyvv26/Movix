package com.ashley.peliculas.di

import com.ashley.peliculas.di.watchList.WatchListMoviesModule
import com.ashley.peliculas.di.watchList.WatchListSubComponent
import com.ashley.peliculas.di.modules.*
import com.ashley.peliculas.di.details.MovieDetailsModule
import com.ashley.peliculas.di.details.MovieDetailsSubComponent
import com.ashley.peliculas.di.favorites.FavoriteModule
import com.ashley.peliculas.di.favorites.FavoritesSubComponent
import com.ashley.peliculas.di.popular.PopularMoviesModule
import com.ashley.peliculas.di.popular.PopularSubComponent
import com.ashley.peliculas.di.search.SearchMoviesModule
import com.ashley.peliculas.di.search.SearchSubComponent
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [
    (AppModule::class),
    (NetworkModule::class),
    (DataModule::class)
])

interface MainComponent {
    fun plus(popularMoviesModule: PopularMoviesModule): PopularSubComponent
    fun plus(favoriteMoviesModule: FavoriteModule): FavoritesSubComponent
    fun plus(WatchListModule: WatchListMoviesModule): WatchListSubComponent
    fun plus(movieDetailsModule: MovieDetailsModule): MovieDetailsSubComponent
    fun plus(searchMoviesModule: SearchMoviesModule): SearchSubComponent
}