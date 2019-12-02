package com.eagskunst.libraries.movieapp.app.app_di

import com.eagskunst.libraries.movieapp.app.di.ApiModule
import com.eagskunst.libraries.movieapp.app.di.ViewModelFactoryModule
import dagger.Component

/**
 * Created by eagskunst in 30/11/2019.
 */

@MovieAppScope
@Component(modules = [MovieAppModule::class, ApiModule::class, ViewModelFactoryModule::class])
interface MovieAppComponent