package com.eagskunst.libraries.movieapp.ui.movie_list.di

import com.eagskunst.libraries.movieapp.app.app_di.MovieAppComponent
import com.eagskunst.libraries.movieapp.app.di.RepositoriesModule
import com.eagskunst.libraries.movieapp.app.di.ViewModelFactoryModule
import com.eagskunst.libraries.movieapp.ui.movie_list.MovieListActivity
import dagger.Component

/**
 * Created by eagskunst in 8/1/2020.
 */
@MovieListScope
@Component(dependencies = [MovieAppComponent::class], modules = [RepositoriesModule::class, ViewModelFactoryModule::class, MovieListModule::class])
interface MovieListComponent {
    fun inject(activity: MovieListActivity)
}