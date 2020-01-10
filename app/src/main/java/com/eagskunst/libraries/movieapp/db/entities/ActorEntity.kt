package com.eagskunst.libraries.movieapp.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by eagskunst in 10/1/2020.
 */
@Entity
data class ActorEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "photo_url") val photoUrl: String?,
    @ColumnInfo(name = "movie_id") val movieId: Int
)