package com.eagskunst.libraries.movieapp.ui.movie_detail.mvvm

import com.eagskunst.libraries.movieapp.app.models.MovieWrapper
import com.eagskunst.libraries.movieapp.db.entities.MovieEntity
import com.eagskunst.libraries.movieapp.utils.base.BaseLocalRepository

class MovieDetailLocalRepository : MovieDetailRepository.LocalRepository, BaseLocalRepository() {

    override suspend fun saveMovieToFavorites(movieWrapper: MovieWrapper) {
        with(database){
            moviesDao().saveMovie(movieWrapper.movie)
            actorsDao().saveActors(movieWrapper.actors)
        }
    }

    override suspend fun deleteMovieFromFavorites(movieEntity: MovieEntity) {
        database.actorsDao().deleteActorsOfMovie(movieEntity.id)
        database.moviesDao().removeMovie(movieEntity)
    }

    override suspend fun getMovie(movieId: Int): MovieEntity? {
        return try {
            database.moviesDao().getSavedMovie(movieId)
        }catch (e: Exception){
            e.printStackTrace()
            null
        }
    }
}