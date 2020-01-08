package com.eagskunst.libraries.movieapp.ui.movie_list.mvvm

import com.eagskunst.libraries.movieapp.app.models.MovieCard
import com.eagskunst.libraries.movieapp.app.network.models.movie_list.MovieListResponse
import com.eagskunst.libraries.movieapp.utils.base.RemoteErrorEmitter

interface MovieListRepository {

    suspend fun getMovieListForCategory(remoteErrorEmitter: RemoteErrorEmitter, category: String, page: Int): List<MovieCard>?

    interface RemoteRepository {
        suspend fun getMovieListForCategory(remoteErrorEmitter: RemoteErrorEmitter, category: String, page: Int): MovieListResponse?
    }

    interface LocalRepository {

    }

}