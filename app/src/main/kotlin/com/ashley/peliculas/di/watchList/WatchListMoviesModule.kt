package com.ashley.peliculas.di.watchList


import com.ashley.domain.MoviesCache
import com.ashley.domain.usecases.GetWatchListMovies
import com.ashley.peliculas.MovieEntityMovieMapper
import com.ashley.peliculas.common.ASyncTransformer
import com.ashley.peliculas.di.DI
import com.ashley.peliculas.watchlist.WatchListVMFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named


@Module
class WatchListMoviesModule {

    @Provides
    fun provideGetWatchListMovies(@Named(DI.watchlistCache) moviesCache: MoviesCache): GetWatchListMovies {
        return GetWatchListMovies(ASyncTransformer(), moviesCache)
    }

    @Provides
    fun provideWatchListVMFactory(getWatchListMovies: GetWatchListMovies,
                                       movieEntityMoveMapper: MovieEntityMovieMapper): WatchListVMFactory {
        return WatchListVMFactory(getWatchListMovies, movieEntityMoveMapper)
    }
}