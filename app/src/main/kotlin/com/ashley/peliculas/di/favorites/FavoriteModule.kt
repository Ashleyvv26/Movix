package com.ashley.peliculas.di.favorites

import com.ashley.domain.MoviesCache
import com.ashley.domain.usecases.GetFavoriteMovies
import com.ashley.peliculas.MovieEntityMovieMapper
import com.ashley.peliculas.common.ASyncTransformer
import com.ashley.peliculas.di.DI
import com.ashley.peliculas.favorites.FavoriteMoviesVMFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named


@Module
class FavoriteModule {

    @Provides
    fun provideGetFavoriteMovies(@Named(DI.favoritesCache) moviesCache: MoviesCache): GetFavoriteMovies {
        return GetFavoriteMovies(ASyncTransformer(), moviesCache)
    }

    @Provides
    fun provideFavoriteMoviesVMFactory(getFavoriteMovies: GetFavoriteMovies,
                                       movieEntityMoveMapper: MovieEntityMovieMapper): FavoriteMoviesVMFactory {
        return FavoriteMoviesVMFactory(getFavoriteMovies, movieEntityMoveMapper)
    }
}