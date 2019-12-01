package com.eagskunst.libraries.movieapp.app

import android.app.Application
import android.content.Context
import com.eagskunst.libraries.movieapp.app.app_di.DaggerMovieAppComponent
import com.eagskunst.libraries.movieapp.app.app_di.MovieAppComponent
import com.eagskunst.libraries.movieapp.app.app_di.MovieAppModule

/**
 * Created by eagskunst in 30/11/2019.
 */
class MoviesApp:  Application() {

    val appComponent: MovieAppComponent by lazy {
        initComponent()
    }

    companion object {

        lateinit var appInstance: MoviesApp
            private set

        val appContext: Context by lazy {
            appInstance.applicationContext
        }

    }

    override fun onCreate() {
        super.onCreate()
        appInstance = this
        initComponent()
    }

    private fun initComponent(): MovieAppComponent {
        return DaggerMovieAppComponent.builder()
            .movieAppModule(MovieAppModule(appInstance)).build()
    }
}