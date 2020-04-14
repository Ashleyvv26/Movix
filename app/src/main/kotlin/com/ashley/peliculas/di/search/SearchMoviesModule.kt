package com.ashley.peliculas.di.search

import com.ashley.domain.MoviesRepository
import com.ashley.domain.usecases.SearchMovie
import com.ashley.peliculas.MovieEntityMovieMapper
import com.ashley.peliculas.common.ASyncTransformer
import com.ashley.peliculas.search.SearchVMFactory
import dagger.Module
import dagger.Provides


@Module
class SearchMoviesModule {

    @Provides
    fun provideSearchMovieUseCase(moviesRepository: MoviesRepository): SearchMovie {
        return SearchMovie(ASyncTransformer(), moviesRepository)
    }

    @Provides
    fun provideSearchVMFactory(useCase: SearchMovie, mapper: MovieEntityMovieMapper): SearchVMFactory {
        return SearchVMFactory(useCase, mapper)
    }
}