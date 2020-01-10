package com.eagskunst.libraries.movieapp.ui.movie_list.mvvm

import androidx.lifecycle.LiveData
import com.eagskunst.libraries.movieapp.app.models.Movie
import com.eagskunst.libraries.movieapp.app.models.MovieCard
import com.eagskunst.libraries.movieapp.app.network.adapters.MovieAdapter
import com.eagskunst.libraries.movieapp.db.entities.MovieWithActors
import com.eagskunst.libraries.movieapp.utils.base.RemoteErrorEmitter

class MovieListRepositoryImpl(private val remoteRepo: MovieListRepository.RemoteRepository,
    private val localRepo: MovieListRepository.LocalRepository) : MovieListRepository {

    override suspend fun getMovieListForCategory(remoteErrorEmitter: RemoteErrorEmitter,
                                                 category: String, page: Int): List<MovieCard>? {
        val response = remoteRepo.getMovieListForCategory(remoteErrorEmitter, category, page)
        val adapter = MovieAdapter()

        return adapter.fromMovieShortDetailListToMovieCardList(response)
    }

    override suspend fun convertMoviesWithActorToMoviesCard(movieWithActors: List<MovieWithActors>): List<MovieCard> {
        val adapter = MovieAdapter()
        return movieWithActors.map { adapter.movieWithActorsToMovieCard(it) }
    }

    override fun getSavedMovies(): LiveData<List<MovieWithActors>> = localRepo.getSavedMovies()

}