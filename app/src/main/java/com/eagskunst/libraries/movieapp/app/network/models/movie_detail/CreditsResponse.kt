package com.eagskunst.libraries.movieapp.app.network.models.movie_detail

import com.squareup.moshi.Json

data class CreditsResponse(
    @Json(name = "cast")
    val cast: List<ActorResponse>?,
    @Json(name = "crew")
    val crew: List<CrewResponse>?
)