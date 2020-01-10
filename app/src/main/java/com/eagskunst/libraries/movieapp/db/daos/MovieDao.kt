package com.eagskunst.libraries.movieapp.db.daos

import androidx.room.*
import com.eagskunst.libraries.movieapp.db.entities.ActorEntity
import com.eagskunst.libraries.movieapp.db.entities.MovieEntity
import com.eagskunst.libraries.movieapp.db.entities.MovieWithActors

/**
 * Created by eagskunst in 10/1/2020.
 */
@Dao
interface MovieDao {
    @Insert
    suspend fun saveMovie(movie: MovieEntity)

    @Delete
    suspend fun removeMovie(movie: MovieEntity)

    @Query("SELECT * FROM movieentity")
    suspend fun getSavedMovieEntities(): List<MovieEntity>

    @Query("SELECT * FROM movieentity WHERE id LIKE :movieId LIMIT 1")
    suspend fun getSavedMovie(movieId: Int): MovieEntity

    @Query("SELECT * FROM actorentity")
    suspend fun getActors(): List<ActorEntity>

    @Transaction
    @Query("SELECT * FROM movieentity")
    fun getMoviesWithActors(): List<MovieWithActors>
}