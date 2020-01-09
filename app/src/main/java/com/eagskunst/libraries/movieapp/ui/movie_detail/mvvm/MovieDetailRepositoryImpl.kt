package com.eagskunst.libraries.movieapp.ui.movie_detail.mvvm

import com.eagskunst.libraries.movieapp.app.models.Movie
import com.eagskunst.libraries.movieapp.app.network.adapters.MovieAdapter
import com.eagskunst.libraries.movieapp.utils.base.RemoteErrorEmitter

class MovieDetailRepositoryImpl(private val remoteRepo: MovieDetailRepository.RemoteRepository,
    private val localRepo: MovieDetailRepository.LocalRepository) : MovieDetailRepository {

    override suspend fun getMovieAndCast(remoteErrorEmitter: RemoteErrorEmitter, movieId: Int): Movie? {
        val response = remoteRepo.getMovieAndCast(remoteErrorEmitter, movieId)
        val adapter = MovieAdapter()
        return adapter.fromMovieDetailResponseToMovie(response)
    }
}