package com.eagskunst.libraries.movieapp.app.network.models.movie_detail

import com.squareup.moshi.Json

data class GenreResponse(
    @Json(name = "id")
    val id: Int?,
    @Json(name = "name")
    val name: String?
)