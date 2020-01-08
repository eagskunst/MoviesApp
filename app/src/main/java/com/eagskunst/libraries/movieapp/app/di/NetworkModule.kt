package com.eagskunst.libraries.movieapp.app.di

import android.content.Context
import android.os.Build
import com.eagskunst.libraries.movieapp.BuildConfig
import com.eagskunst.libraries.movieapp.app.MoviesApp
import com.eagskunst.libraries.movieapp.app.app_di.MovieAppScope
import com.eagskunst.libraries.movieapp.app.interceptor.ConnectivityInterceptor
import com.eagskunst.libraries.movieapp.utils.ApiKeys
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.util.concurrent.TimeUnit
/**
 * Created by eagskunst in 30/11/2019.
 */
@Module
class NetworkModule {

    @Provides
    @MovieAppScope
    fun provideInterceptor(): HttpLoggingInterceptor {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    @MovieAppScope
    fun provideCache(cacheFile: File): Cache {
        return Cache(cacheFile, 10 * 1000 * 1000) //10MB Cahe
    }

    @Provides
    @MovieAppScope
    fun provideCacheFile(context: Context): File {
        return File(context.cacheDir, "okhttp_cache")
    }

    @Provides
    @MovieAppScope
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor, cache: Cache): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(ConnectivityInterceptor(MoviesApp.appContext))
            .addInterceptor { chain ->
                val requestBuilder = chain.request().newBuilder()
                    .addHeader(
                        "User-Agent",
                        "MoviesApp" + " BUILD VERSION: " + BuildConfig.VERSION_NAME + " SMARTPHONE: " + Build.MODEL + " ANDROID VERSION: " + Build.VERSION.RELEASE
                    )
                    .addHeader("Content-Type", "application/json")

                val httpUrl = chain.request()
                    .url
                    .newBuilder()
                    .addQueryParameter("api_key", ApiKeys.MOVIE_API_KEY).build()

                val request = requestBuilder
                    .url(httpUrl)
                    .build()

                chain.proceed(request)
            }
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .cache(cache)
            .build()
    }


}