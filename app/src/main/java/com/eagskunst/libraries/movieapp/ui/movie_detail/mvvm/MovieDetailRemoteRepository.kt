package com.eagskunst.libraries.movieapp.ui.movie_detail.mvvm

import com.eagskunst.libraries.movieapp.app.network.api.MovieDetailApi
import com.eagskunst.libraries.movieapp.app.network.models.movie_detail.MovieDetailResponse
import com.eagskunst.libraries.movieapp.utils.base.BaseRemoteRepository
import com.eagskunst.libraries.movieapp.utils.base.RemoteErrorEmitter

class MovieDetailRemoteRepository(private val api: MovieDetailApi) :
    BaseRemoteRepository(), MovieDetailRepository.RemoteRepository {

    override suspend fun getMovieAndCast(remoteErrorEmitter: RemoteErrorEmitter, movieId: Int):
            MovieDetailResponse? {
        return safeApiCall(remoteErrorEmitter){ api.getMovieAndCredits(id = movieId) }
    }

}