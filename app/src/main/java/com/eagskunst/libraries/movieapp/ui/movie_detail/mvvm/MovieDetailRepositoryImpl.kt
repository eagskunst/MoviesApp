package com.eagskunst.libraries.movieapp.ui.movie_detail.mvvm

import com.eagskunst.libraries.movieapp.app.models.Movie
import com.eagskunst.libraries.movieapp.app.network.adapters.MovieAdapter
import com.eagskunst.libraries.movieapp.utils.base.RemoteErrorEmitter

class MovieDetailRepositoryImpl(private val remoteRepo: MovieDetailRepository.RemoteRepository,
    private val localRepo: MovieDetailRepository.LocalRepository) : MovieDetailRepository {

    private val adapter = MovieAdapter()

    override suspend fun getMovieAndCast(remoteErrorEmitter: RemoteErrorEmitter, movieId: Int): Movie? {
        val response = remoteRepo.getMovieAndCast(remoteErrorEmitter, movieId)
        val movie = adapter.fromMovieDetailResponseToMovie(response)
        if(movie == null) return movie
        val movieEntity = localRepo.getMovie(movieId) ?: return movie
        return movie.copy(isFavorite = movieEntity.isFavorite)
    }

    override suspend fun saveMovieToFavorites(movie: Movie) {
        localRepo.saveMovieToFavorites(adapter.movieToMovieWrapper(movie))
    }

    override suspend fun deleteMovieFromFavorites(movie: Movie) {
        localRepo.deleteMovieFromFavorites(adapter.movieToMovieEntity(movie))
    }
}