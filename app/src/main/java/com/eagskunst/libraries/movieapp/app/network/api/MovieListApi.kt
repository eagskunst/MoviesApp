package com.eagskunst.libraries.movieapp.app.network.api

import com.eagskunst.libraries.movieapp.app.network.models.movie_list.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by eagskunst in 8/1/2020.
 */
interface MovieListApi {

    @GET("movie/{category}")
    suspend fun getMovieListForCategory(@Path("category") category: String,
                                @Query("page") page: Int) : MovieListResponse
}