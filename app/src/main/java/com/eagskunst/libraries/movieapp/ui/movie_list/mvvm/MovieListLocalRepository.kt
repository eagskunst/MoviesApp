package com.eagskunst.libraries.movieapp.ui.movie_list.mvvm

import androidx.lifecycle.LiveData
import com.eagskunst.libraries.movieapp.db.entities.MovieWithActors
import com.eagskunst.libraries.movieapp.utils.base.BaseLocalRepository

class MovieListLocalRepository : MovieListRepository.LocalRepository, BaseLocalRepository() {

    override fun getSavedMovies(): LiveData<List<MovieWithActors>> = database.moviesDao().getMoviesWithActors()
}