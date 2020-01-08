package com.eagskunst.libraries.movieapp.ui.movie_list.mvvm

import com.eagskunst.libraries.movieapp.app.network.api.MovieListApi
import com.eagskunst.libraries.movieapp.app.network.models.movie_list.MovieListResponse
import com.eagskunst.libraries.movieapp.utils.base.BaseRemoteRepository
import com.eagskunst.libraries.movieapp.utils.base.RemoteErrorEmitter

class MovieListRemoteRepository(private val api: MovieListApi) : BaseRemoteRepository(),
    MovieListRepository.RemoteRepository {

    override suspend fun getMovieListForCategory(remoteErrorEmitter: RemoteErrorEmitter, category: String, page: Int): MovieListResponse? {
        return safeApiCall(remoteErrorEmitter){ api.getMovieListForCategory(category, page) }
    }
}