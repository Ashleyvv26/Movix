package com.ashley.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.ashley.data.entities.MovieData


@Database(entities = arrayOf(MovieData::class), version = 1)
abstract class MoviesDatabase: RoomDatabase() {
    abstract fun getMoviesDao(): MoviesDao
}