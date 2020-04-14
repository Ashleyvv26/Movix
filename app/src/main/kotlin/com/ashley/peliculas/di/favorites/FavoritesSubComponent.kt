package com.ashley.peliculas.di.favorites

import com.ashley.peliculas.favorites.FavoriteMoviesFragment
import dagger.Subcomponent


@FavoritesScope
@Subcomponent(modules = [FavoriteModule::class])
interface FavoritesSubComponent {
    fun inject(favoriteMoviesFragment: FavoriteMoviesFragment)
}