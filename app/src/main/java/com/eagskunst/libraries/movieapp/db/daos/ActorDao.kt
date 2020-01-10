package com.eagskunst.libraries.movieapp.db.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.eagskunst.libraries.movieapp.db.entities.ActorEntity

/**
 * Created by eagskunst in 10/1/2020.
 */
@Dao
interface ActorDao {
    @Query("SELECT * FROM actorentity")
    suspend fun getActors(): List<ActorEntity>

    @Insert
    suspend fun saveActors(actor: List<ActorEntity>)

    @Delete
    suspend fun deleteActor(actor: ActorEntity)

    @Query("DELETE FROM actorentity WHERE movie_id LIKE :movieId")
    suspend fun deleteActorsOfMovie(movieId: Int)
}