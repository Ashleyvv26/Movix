package com.ashley.peliculas.di.details

import com.ashley.domain.MoviesCache
import com.ashley.domain.MoviesRepository
import com.ashley.domain.usecases.CheckFavoriteStatus
import com.ashley.domain.usecases.GetMovieDetails
import com.ashley.domain.usecases.RemoveFavoriteMovie
import com.ashley.domain.usecases.SaveFavoriteMovie
import com.ashley.peliculas.MovieEntityMovieMapper
import com.ashley.peliculas.common.ASyncTransformer
import com.ashley.peliculas.details.MovieDetailsVMFactory
import com.ashley.peliculas.di.DI
import dagger.Module
import dagger.Provides
import javax.inject.Named


@Module
class MovieDetailsModule {

    @Provides
    fun provideRemoveFavoriteMovie(@Named(DI.favoritesCache) moviesCache: MoviesCache): RemoveFavoriteMovie {
        return RemoveFavoriteMovie(ASyncTransformer(), moviesCache)
    }

    @Provides
    fun provideCheckFavoriteStatus(@Named(DI.favoritesCache) moviesCache: MoviesCache): CheckFavoriteStatus {
        return CheckFavoriteStatus(ASyncTransformer(), moviesCache)
    }

    @Provides
    fun provideSaveFavoriteMovieUseCase(@Named(DI.favoritesCache) moviesCache: MoviesCache): SaveFavoriteMovie {
        return SaveFavoriteMovie(ASyncTransformer(), moviesCache)
    }

    @Provides
    fun provideGetMovieDetailsUseCase(moviesRepository: MoviesRepository): GetMovieDetails {
        return GetMovieDetails(ASyncTransformer(), moviesRepository)
    }

    @Provides
    fun provideMovieDetailsVMFactory(getMovieDetails: GetMovieDetails,
                                     saveFavoriteMovie: SaveFavoriteMovie,
                                     removeFavoriteMovie: RemoveFavoriteMovie,
                                     checkFavoriteStatus: CheckFavoriteStatus,
                                     mapper: MovieEntityMovieMapper): MovieDetailsVMFactory {
        return MovieDetailsVMFactory(getMovieDetails, saveFavoriteMovie, removeFavoriteMovie, checkFavoriteStatus, mapper)
    }
}