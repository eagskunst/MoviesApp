package com.eagskunst.libraries.movieapp.app.network.api

import com.eagskunst.libraries.movieapp.app.network.models.movie_detail.MovieDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by eagskunst in 9/1/2020.
 */
interface MovieDetailApi {
    @GET("movie/{movie_id}")
    suspend fun getMovieAndCredits(@Path("movie_id") id: Int,
                                   @Query("append_to_response") appendToResponse: String = "credits"): MovieDetailResponse
}