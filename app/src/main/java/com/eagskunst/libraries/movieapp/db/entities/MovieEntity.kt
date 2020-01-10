package com.eagskunst.libraries.movieapp.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by eagskunst in 10/1/2020.
 */
@Entity
data class MovieEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "photo_url") val photoUrl: String?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "rate") val rating: Float,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "studio") val studio: String?,
    @ColumnInfo(name = "genres") val genres: String?,
    @ColumnInfo(name = "releaseDate") val releaseDate: String?,
    @ColumnInfo(name = "is_favorite") val isFavorite: Boolean
)