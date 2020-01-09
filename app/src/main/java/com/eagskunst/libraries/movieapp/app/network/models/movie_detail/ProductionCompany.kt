package com.eagskunst.libraries.movieapp.app.network.models.movie_detail

import com.squareup.moshi.Json

data class ProductionCompany(
    @Json(name = "id")
    val id: Int?,
    @Json(name = "logo_path")
    val logoPath: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "origin_country")
    val originCountry: String?
)