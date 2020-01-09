package com.eagskunst.libraries.movieapp.ui.movie_list.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.eagskunst.libraries.movieapp.app.models.MovieCard
import com.eagskunst.libraries.movieapp.utils.base.BaseViewModel
import com.kinesis.kinesisapp.utils.base.ScreenState
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieListViewModel @Inject constructor(private val movieListRepo: MovieListRepository) : BaseViewModel() {

    private val _movieList = MutableLiveData<List<MovieCard>>(listOf())
    val movieList: LiveData<List<MovieCard>> = _movieList


    fun getMovieListForCategory(category: String, page: Int = 1){
        viewModelScope.launch {
            mutableScreenState.postValue(ScreenState.LOADING)
            val list = movieListRepo.getMovieListForCategory(this@MovieListViewModel,
                category, page)
            _movieList.postValue(list)
            val newState = if(list == null) ScreenState.ERROR else ScreenState.RENDER
            mutableScreenState.postValue(newState)
        }
    }
}