package com.eagskunst.libraries.movieapp.ui.movie_list.mvvm

import androidx.lifecycle.LiveData
import com.eagskunst.libraries.movieapp.app.models.Movie
import com.eagskunst.libraries.movieapp.app.models.MovieCard
import com.eagskunst.libraries.movieapp.app.network.models.movie_list.MovieListResponse
import com.eagskunst.libraries.movieapp.db.entities.MovieWithActors
import com.eagskunst.libraries.movieapp.utils.base.RemoteErrorEmitter

interface MovieListRepository {

    suspend fun getMovieListForCategory(remoteErrorEmitter: RemoteErrorEmitter, category: String, page: Int): List<MovieCard>?
    fun getSavedMovies(): LiveData<List<MovieWithActors>>
    suspend fun convertMoviesWithActorToMoviesCard(movieWithActors: List<MovieWithActors>): List<MovieCard>

    interface RemoteRepository {
        suspend fun getMovieListForCategory(remoteErrorEmitter: RemoteErrorEmitter, category: String, page: Int): MovieListResponse?
    }

    interface LocalRepository {
        fun getSavedMovies(): LiveData<List<MovieWithActors>>
    }

}