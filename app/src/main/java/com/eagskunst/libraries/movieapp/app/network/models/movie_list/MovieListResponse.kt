package com.eagskunst.libraries.movieapp.app.network.models.movie_list

import com.squareup.moshi.Json

data class MovieListResponse(
    @Json(name = "page")
    val page: Int = 1,
    @Json(name = "results")
    val results: List<MovieShortDetail>?,
    @Json(name = "total_pages")
    val totalPages: Int = 1,
    @Json(name = "total_results")
    val totalResults: Int = 1
)