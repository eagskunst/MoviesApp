package com.eagskunst.libraries.movieapp.ui.movie_detail.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.eagskunst.libraries.movieapp.app.models.Movie
import com.eagskunst.libraries.movieapp.utils.base.BaseViewModel
import com.kinesis.kinesisapp.utils.base.ScreenState
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(private val repository: MovieDetailRepository) : BaseViewModel() {

    private val _movieLiveData = MutableLiveData<Movie>()
    val movieLiveData = _movieLiveData as LiveData<Movie>

    fun getMovieAndCast(movieId: Int){
        val movie = _movieLiveData.value
        if(movie != null) return
        viewModelScope.launch {
            mutableScreenState.postValue(ScreenState.LOADING)
            val movie = repository.getMovieAndCast(this@MovieDetailViewModel, movieId)
            _movieLiveData.postValue(movie)
            val newState = if(movie == null) ScreenState.ERROR else ScreenState.RENDER
            mutableScreenState.postValue(newState)
        }
    }
}