package com.eagskunst.libraries.movieapp.ui.movie_list.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.eagskunst.libraries.movieapp.app.models.MovieCard
import com.eagskunst.libraries.movieapp.db.entities.MovieWithActors
import com.eagskunst.libraries.movieapp.utils.base.BaseViewModel
import com.kinesis.kinesisapp.utils.base.ScreenState
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieListViewModel @Inject constructor(private val movieListRepo: MovieListRepository) : BaseViewModel() {

    private val _movieList = MutableLiveData<List<MovieCard>>()
    val movieList: LiveData<List<MovieCard>> = _movieList
    val savedMoviesList = movieListRepo.getSavedMovies()


    fun getMovieListForCategory(category: String, page: Int = 1){
        if(_movieList.value != null && _movieList.value!!.isNotEmpty()) return
        viewModelScope.launch {
            mutableScreenState.postValue(ScreenState.LOADING)
            val list = movieListRepo.getMovieListForCategory(this@MovieListViewModel,
                category, page)
            _movieList.postValue(list)
            val newState = if(list == null) ScreenState.ERROR else ScreenState.RENDER
            mutableScreenState.postValue(newState)
        }
    }

    fun updateMovieList(movieWithActors: List<MovieWithActors>) {
        viewModelScope.launch {
            mutableScreenState.postValue(ScreenState.LOADING)
            val movies = movieListRepo.convertMoviesWithActorToMoviesCard(movieWithActors)
            _movieList.postValue(movies)
            mutableScreenState.postValue(ScreenState.RENDER)
        }
    }
}