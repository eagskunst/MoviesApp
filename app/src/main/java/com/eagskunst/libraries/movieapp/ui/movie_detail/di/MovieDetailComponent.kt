package com.eagskunst.libraries.movieapp.ui.movie_detail.di

import com.eagskunst.libraries.movieapp.app.app_di.MovieAppComponent
import com.eagskunst.libraries.movieapp.ui.movie_detail.MovieDetailActivity
import dagger.Component

/**
 * Created by eagskunst in 9/1/2020.
 */
@MovieDetailScope
@Component(dependencies = [MovieAppComponent::class])
interface MovieDetailComponent {
    fun inject(activity: MovieDetailActivity)
}