package com.ashley.peliculas.di.search

import com.ashley.peliculas.search.SearchFragment
import dagger.Subcomponent


@SearchScope
@Subcomponent(modules = [SearchMoviesModule::class])
interface SearchSubComponent {
    fun inject(searchFragment: SearchFragment)
}