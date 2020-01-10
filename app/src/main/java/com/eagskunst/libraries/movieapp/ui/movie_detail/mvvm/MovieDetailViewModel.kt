package com.eagskunst.libraries.movieapp.ui.movie_detail.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.eagskunst.libraries.movieapp.app.models.Movie
import com.eagskunst.libraries.movieapp.utils.base.BaseViewModel
import com.kinesis.kinesisapp.utils.base.ScreenState
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(private val repository: MovieDetailRepository) : BaseViewModel() {

    private val _movieLiveData = MutableLiveData<Movie>()
    val movieLiveData = _movieLiveData as LiveData<Movie>
    val savedMoviesList = repository.getSavedMovies()

    fun getMovieAndCast(movieId: Int){
        val movieValue = _movieLiveData.value
        if(movieValue != null) return
        viewModelScope.launch {
            mutableScreenState.postValue(ScreenState.LOADING)
            val movie = repository.getMovieAndCast(this@MovieDetailViewModel, movieId)
            _movieLiveData.postValue(movie)
            val newState = if(movie == null) ScreenState.ERROR else ScreenState.RENDER
            mutableScreenState.postValue(newState)
        }
    }

    fun updateMovie(movie: Movie, isFavorite: Boolean){
        viewModelScope.launch {
            if(!isFavorite)
                repository.saveMovieToFavorites(movie)
            else
                repository.deleteMovieFromFavorites(movie)

            _movieLiveData.postValue(movie.copy(isFavorite = !isFavorite))
        }
    }
}