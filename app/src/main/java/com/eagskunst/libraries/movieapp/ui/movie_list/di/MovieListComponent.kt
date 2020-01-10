package com.eagskunst.libraries.movieapp.ui.movie_list.di

import com.eagskunst.libraries.movieapp.app.app_di.MovieAppComponent
import com.eagskunst.libraries.movieapp.ui.movie_list.MovieListActivity
import dagger.Component

/**
 * Created by eagskunst in 8/1/2020.
 */
@MovieListScope
@Component(dependencies = [MovieAppComponent::class])
interface MovieListComponent {
    fun inject(activity: MovieListActivity)
}