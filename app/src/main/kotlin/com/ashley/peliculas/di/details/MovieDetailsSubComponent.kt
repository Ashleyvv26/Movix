package com.ashley.peliculas.di.details

import com.ashley.peliculas.details.MovieDetailsActivity
import dagger.Subcomponent


@DetailsScope
@Subcomponent(modules = [MovieDetailsModule::class])
interface MovieDetailsSubComponent {
    fun inject(movieDetailsActivity: MovieDetailsActivity)
}