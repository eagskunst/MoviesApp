package com.eagskunst.libraries.movieapp.ui.movie_detail.mvvm

import androidx.lifecycle.LiveData
import com.eagskunst.libraries.movieapp.app.models.Movie
import com.eagskunst.libraries.movieapp.app.models.MovieWrapper
import com.eagskunst.libraries.movieapp.app.network.models.movie_detail.MovieDetailResponse
import com.eagskunst.libraries.movieapp.db.entities.MovieEntity
import com.eagskunst.libraries.movieapp.db.entities.MovieWithActors
import com.eagskunst.libraries.movieapp.utils.base.RemoteErrorEmitter

interface MovieDetailRepository {

    suspend fun getMovieAndCast(remoteErrorEmitter: RemoteErrorEmitter, movieId: Int): Movie?
    suspend fun saveMovieToFavorites(movie: Movie)
    suspend fun deleteMovieFromFavorites(movie: Movie)
    fun getSavedMovies(): LiveData<List<MovieWithActors>>

    interface RemoteRepository {
        suspend fun getMovieAndCast(remoteErrorEmitter: RemoteErrorEmitter, movieId: Int): MovieDetailResponse?
    }

    interface LocalRepository {
        suspend fun saveMovieToFavorites(movieWrapper: MovieWrapper)
        suspend fun deleteMovieFromFavorites(movieEntity: MovieEntity)
        suspend fun getMovie(movieId: Int): MovieEntity?
        fun getSavedMovies(): LiveData<List<MovieWithActors>>
    }

}