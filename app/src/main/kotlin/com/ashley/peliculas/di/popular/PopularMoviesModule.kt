package com.ashley.peliculas.di.popular

import com.ashley.domain.MoviesRepository
import com.ashley.domain.usecases.GetPopularMovies
import com.ashley.peliculas.MovieEntityMovieMapper
import com.ashley.peliculas.common.ASyncTransformer
import com.ashley.peliculas.popularmovies.PopularMoviesVMFactory
import dagger.Module
import dagger.Provides


@PopularScope
@Module
class PopularMoviesModule {
    @Provides
    fun provideGetPopularMoviesUseCase(moviesRepository: MoviesRepository): GetPopularMovies {
        return GetPopularMovies(ASyncTransformer(), moviesRepository)
    }

    @Provides
    fun providePopularMoviesVMFactory(useCase: GetPopularMovies, mapper: MovieEntityMovieMapper): PopularMoviesVMFactory {
        return PopularMoviesVMFactory(useCase, mapper)
    }
}