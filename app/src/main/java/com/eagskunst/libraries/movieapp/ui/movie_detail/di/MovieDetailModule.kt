package com.eagskunst.libraries.movieapp.ui.movie_detail.di

import androidx.lifecycle.ViewModel
import com.eagskunst.libraries.movieapp.app.di.ViewModelKey
import com.eagskunst.libraries.movieapp.ui.movie_detail.mvvm.MovieDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by eagskunst in 9/1/2020.
 */
@Module
abstract class MovieDetailModule {
    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel::class)
    abstract fun bind(movieDetailViewModel: MovieDetailViewModel): ViewModel
}