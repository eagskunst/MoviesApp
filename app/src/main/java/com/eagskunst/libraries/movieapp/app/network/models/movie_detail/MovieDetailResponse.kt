package com.eagskunst.libraries.movieapp.app.network.models.movie_detail

import com.squareup.moshi.Json

data class MovieDetailResponse(
    @Json(name = "adult")
    val adult: Boolean,
    @Json(name = "backdrop_path")
    val backdropPath: String?,
    @Json(name = "belongs_to_collection")
    val belongsToCollection: BelongsToCollection?,
    @Json(name = "budget")
    val budget: Int = 0,
    @Json(name = "credits")
    val credits: CreditsResponse?,
    @Json(name = "genres")
    val genres: List<GenreResponse?>?,
    @Json(name = "homepage")
    val homepage: String?,
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "imdb_id")
    val imdbId: String?,
    @Json(name = "original_language")
    val originalLanguage: String?,
    @Json(name = "original_title")
    val originalTitle: String?,
    @Json(name = "overview")
    val overview: String?,
    @Json(name = "popularity")
    val popularity: Double?,
    @Json(name = "poster_path")
    val posterPath: String?,
    @Json(name = "production_companies")
    val productionCompanies: List<ProductionCompany?>?,
    @Json(name = "production_countries")
    val productionCountries: List<ProductionCountry?>?,
    @Json(name = "release_date")
    val releaseDate: String?,
    @Json(name = "revenue")
    val revenue: Int = 0,
    @Json(name = "runtime")
    val runtime: Int = 0,
    @Json(name = "spoken_languages")
    val spokenLanguages: List<SpokenLanguage?>?,
    @Json(name = "status")
    val status: String?,
    @Json(name = "tagline")
    val tagline: String?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "video")
    val video: Boolean,
    @Json(name = "vote_average")
    val voteAverage: Double?,
    @Json(name = "vote_count")
    val voteCount: Int = 0
)