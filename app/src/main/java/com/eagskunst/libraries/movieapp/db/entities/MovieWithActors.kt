package com.eagskunst.libraries.movieapp.db.entities

import androidx.room.Embedded
import androidx.room.Relation

/**
 * Created by eagskunst in 10/1/2020.
 */
data class MovieWithActors(
    @Embedded val movie: MovieEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "movie_id"
    )
    val actors: List<ActorEntity>
)