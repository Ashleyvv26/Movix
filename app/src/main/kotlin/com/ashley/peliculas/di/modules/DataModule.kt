package com.ashley.peliculas.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import com.ashley.data.api.Api
import com.ashley.data.db.MoviesDatabase
import com.ashley.data.db.RoomFavoritesMovieCache
import com.ashley.data.db.RoomWatchListMovieCache
import com.ashley.data.mappers.MovieDataEntityMapper
import com.ashley.data.mappers.MovieEntityDataMapper
import com.ashley.data.repositories.*
import com.ashley.domain.MoviesCache
import com.ashley.domain.MoviesRepository
import com.ashley.peliculas.di.DI
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton


@Module
@Singleton
class DataModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(context: Context): MoviesDatabase {
        return Room.databaseBuilder(
                context,
                MoviesDatabase::class.java,
                "movies_db").build()
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api: Api,
                               @Named(DI.inMemoryCache) cache: MoviesCache): MoviesRepository {

        val cachedMoviesDataStore = CachedMoviesDataStore(cache)
        val remoteMoviesDataStore = RemoteMoviesDataStore(api)
        return MoviesRepositoryImpl(cachedMoviesDataStore, remoteMoviesDataStore)
    }

    @Singleton
    @Provides
    @Named(DI.inMemoryCache)
    fun provideInMemoryMoviesCache(): MoviesCache {
        return MemoryMoviesCache()
    }

    @Singleton
    @Provides
    @Named(DI.favoritesCache)
    fun provideFavoriteMoviesCache(moviesDatabase: MoviesDatabase,
                                   entityDataMapper: MovieEntityDataMapper,
                                   dataEntityMapper: MovieDataEntityMapper): MoviesCache {
        return RoomFavoritesMovieCache(moviesDatabase, entityDataMapper, dataEntityMapper)
    }

    @Singleton
    @Provides
    @Named(DI.watchlistCache)
    fun provideWatchListMoviesCache(moviesDatabase: MoviesDatabase,
                                   entityDataMapper: MovieEntityDataMapper,
                                   dataEntityMapper: MovieDataEntityMapper): MoviesCache {
        return RoomWatchListMovieCache(moviesDatabase, entityDataMapper, dataEntityMapper)
    }
}