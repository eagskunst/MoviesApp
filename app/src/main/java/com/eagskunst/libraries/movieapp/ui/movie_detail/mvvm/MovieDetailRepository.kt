package com.eagskunst.libraries.movieapp.ui.movie_detail.mvvm

import com.eagskunst.libraries.movieapp.app.models.Movie
import com.eagskunst.libraries.movieapp.app.network.models.movie_detail.MovieDetailResponse
import com.eagskunst.libraries.movieapp.utils.base.RemoteErrorEmitter

interface MovieDetailRepository {

    suspend fun getMovieAndCast(remoteErrorEmitter: RemoteErrorEmitter, movieId: Int): Movie?

    interface RemoteRepository {
        suspend fun getMovieAndCast(remoteErrorEmitter: RemoteErrorEmitter, movieId: Int): MovieDetailResponse?
    }

    interface LocalRepository {

    }

}