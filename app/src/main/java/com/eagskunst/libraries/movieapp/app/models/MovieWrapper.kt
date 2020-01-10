package com.eagskunst.libraries.movieapp.app.models

import com.eagskunst.libraries.movieapp.db.entities.ActorEntity
import com.eagskunst.libraries.movieapp.db.entities.MovieEntity

/**
 * Created by eagskunst in 10/1/2020.
 */
data class MovieWrapper(
    val movie: MovieEntity,
    val actors: List<ActorEntity>
)