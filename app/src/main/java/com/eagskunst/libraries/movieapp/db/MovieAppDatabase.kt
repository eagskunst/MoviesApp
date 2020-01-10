package com.eagskunst.libraries.movieapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.eagskunst.libraries.movieapp.db.daos.ActorDao
import com.eagskunst.libraries.movieapp.db.daos.MovieDao
import com.eagskunst.libraries.movieapp.db.entities.*
import com.eagskunst.libraries.movieapp.utils.Constants

/**
 * Created by eagskunst in 10/1/2020.
 */
@Database(entities = [MovieEntity::class, ActorEntity::class], version = Constants.DB_VERSION)
abstract class MovieAppDatabase: RoomDatabase(){
    abstract fun moviesDao(): MovieDao
    abstract fun actorsDao(): ActorDao
}