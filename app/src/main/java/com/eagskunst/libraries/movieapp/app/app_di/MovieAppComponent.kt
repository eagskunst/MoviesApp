package com.eagskunst.libraries.movieapp.app.app_di

import com.eagskunst.libraries.movieapp.app.di.ApiModule
import com.eagskunst.libraries.movieapp.app.di.RepositoriesModule
import com.eagskunst.libraries.movieapp.app.di.ViewModelFactoryModule
import com.eagskunst.libraries.movieapp.app.network.api.MovieListApi
import com.eagskunst.libraries.movieapp.ui.movie_list.mvvm.MovieListRepository
import dagger.Component

/**
 * Created by eagskunst in 30/11/2019.
 */

@MovieAppScope
@Component(modules = [MovieAppModule::class, ApiModule::class, RepositoriesModule::class, ViewModelFactoryModule::class])
interface MovieAppComponent {
    fun movieListApi(): MovieListApi
    fun movieListRepository(): MovieListRepository
}