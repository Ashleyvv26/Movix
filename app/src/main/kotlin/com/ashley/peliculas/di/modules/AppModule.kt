package com.ashley.peliculas.di.modules

import android.content.Context
import com.squareup.picasso.Picasso
import com.ashley.peliculas.common.ImageLoader
import com.ashley.peliculas.common.PicassoImageLoader
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule constructor(context: Context){

    private val appContext = context.applicationContext

    @Singleton
    @Provides
    fun provideAppContext(): Context {
        return appContext
    }

    @Singleton
    @Provides
    fun provideImageLoader(context: Context) : ImageLoader {
        return PicassoImageLoader(Picasso.with(context))
    }
}