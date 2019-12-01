package com.eagskunst.libraries.movieapp.app.di

import android.content.res.Resources
import com.eagskunst.libraries.movieapp.app.app_di.MovieAppScope
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by eagskunst in 30/11/2019.
 */
@Module(includes = [NetworkModule::class])
class RetrofitModule {

    @Provides
    @MovieAppScope
    fun provideBaseUrl(resources: Resources): String {
        TODO("Add base URL to resources")
        return "www.google.com"
    }


    @Provides
    @MovieAppScope
    fun provideMoshi(): Moshi =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

    @Provides
    @MovieAppScope
    fun provideRetrofit(okHttpClient: OkHttpClient, url: String, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .baseUrl(url)
            .build()
    }


}