package com.eagskunst.libraries.movieapp.app.models

/**
 * Created by eagskunst in 8/12/2019.
 */

data class Movie(val id: String,
                 val photoUrl: String?,
                 val name: String?,
                 val rating: Float = 0f,
                 val description: String?,
                 val actors: List<Actor>?,
                 val studio: String?,
                 val genres: String?,
                 val releaseDate: String?
                 )