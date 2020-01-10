package com.eagskunst.libraries.movieapp.ui.movie_detail.mvvm

import androidx.lifecycle.LiveData
import com.eagskunst.libraries.movieapp.app.models.MovieWrapper
import com.eagskunst.libraries.movieapp.db.entities.MovieEntity
import com.eagskunst.libraries.movieapp.db.entities.MovieWithActors
import com.eagskunst.libraries.movieapp.utils.base.BaseLocalRepository

class MovieDetailLocalRepository : MovieDetailRepository.LocalRepository, BaseLocalRepository() {

    override suspend fun saveMovieToFavorites(movieWrapper: MovieWrapper) {
        with(database){
            moviesDao().saveMovie(movieWrapper.movie)
            actorsDao().saveActors(movieWrapper.actors)
        }
    }

    override suspend fun deleteMovieFromFavorites(movieEntity: MovieEntity) {
        database.moviesDao().removeMovie(movieEntity)
        database.actorsDao().deleteActorsOfMovie(movieEntity.id)
    }

    override fun getSavedMovies(): LiveData<List<MovieWithActors>> = database.moviesDao().getMoviesWithActors()
}