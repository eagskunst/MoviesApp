package com.eagskunst.libraries.movieapp.app.app_di

import android.content.Context
import android.content.res.AssetManager
import android.content.res.Resources
import com.eagskunst.libraries.movieapp.app.MoviesApp
import dagger.Module
import dagger.Provides

/**
 * Created by eagskunst in 30/11/2019.
 */
@Module
class MovieAppModule(private val app: MoviesApp){
    @Provides
    @MovieAppScope
    fun provideApp(): MoviesApp = app

    @Provides
    @MovieAppScope
    fun provideResources(): Resources {
        return app.resources
    }

    @Provides
    @MovieAppScope
    fun provideApplicationContext(): Context {
        return app
    }

    @Provides
    @MovieAppScope
    fun provideAppComponent(appComponent: MovieAppComponent): MovieAppComponent {
        return appComponent
    }

    @Provides
    @MovieAppScope
    fun provideAssets() : AssetManager {
        return app.assets
    }
}