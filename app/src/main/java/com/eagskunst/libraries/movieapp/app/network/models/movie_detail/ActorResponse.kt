package com.eagskunst.libraries.movieapp.app.network.models.movie_detail

import com.squareup.moshi.Json

data class ActorResponse(
    @Json(name = "cast_id")
    val castId: Int = 0,
    @Json(name = "character")
    val character: String?,
    @Json(name = "credit_id")
    val creditId: String?,
    @Json(name = "gender")
    val gender: Int = 0,
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "name")
    val name: String?,
    @Json(name = "order")
    val order: Int = 0,
    @Json(name = "profile_path")
    val profilePath: String?
)