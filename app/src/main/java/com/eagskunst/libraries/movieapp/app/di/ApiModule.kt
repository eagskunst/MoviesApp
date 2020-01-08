package com.eagskunst.libraries.movieapp.app.di

import com.eagskunst.libraries.movieapp.app.app_di.MovieAppScope
import com.eagskunst.libraries.movieapp.app.network.api.MovieListApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by eagskunst in 30/11/2019.
 */
@Module(includes = [RetrofitModule::class])
class ApiModule {
    @Provides
    @MovieAppScope
    fun provideMovieListApi(retrofit: Retrofit): MovieListApi = retrofit.create(MovieListApi::class.java)
}