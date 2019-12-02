package com.eagskunst.libraries.movieapp.app.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

/**
 * Created by eagskunst in 1/12/2019.
 */
@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}