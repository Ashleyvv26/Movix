package com.ashley.peliculas.di.watchList

import com.ashley.peliculas.watchlist.WatchListMoviesFragment
import dagger.Subcomponent


@WatchListScope
@Subcomponent(modules = [WatchListMoviesModule::class])
interface WatchListSubComponent {
    fun inject(WatchListMoviesFragment: WatchListMoviesFragment)
}