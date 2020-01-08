package com.eagskunst.libraries.movieapp.ui.movie_list.di

import androidx.lifecycle.ViewModel
import com.eagskunst.libraries.movieapp.app.di.ViewModelKey
import com.eagskunst.libraries.movieapp.ui.movie_list.mvvm.MovieListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by eagskunst in 8/1/2020.
 */
@Module
abstract class MovieListModule {
    @Binds
    @IntoMap
    @ViewModelKey(MovieListViewModel::class)
    abstract fun bindMovieListViewModel(movieListViewModel: MovieListViewModel): ViewModel
}