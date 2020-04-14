package com.ashley.peliculas.di.popular

import com.ashley.peliculas.popularmovies.PopularMoviesFragment
import dagger.Subcomponent


@Subcomponent(modules = [PopularMoviesModule::class])
interface PopularSubComponent {
    fun inject(popularMoviesFragment: PopularMoviesFragment)
}