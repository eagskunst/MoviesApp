package com.eagskunst.libraries.movieapp.ui.movie_detail

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.eagskunst.libraries.movieapp.R
import com.eagskunst.libraries.movieapp.app.MoviesApp
import com.eagskunst.libraries.movieapp.app.app_di.MovieAppComponent
import com.eagskunst.libraries.movieapp.app.di.ViewModelFactory
import com.eagskunst.libraries.movieapp.app.models.Movie
import com.eagskunst.libraries.movieapp.databinding.ActivityMovieDetailBinding
import com.eagskunst.libraries.movieapp.ui.movie_detail.di.DaggerMovieDetailComponent
import com.eagskunst.libraries.movieapp.ui.movie_detail.mvvm.MovieDetailViewModel
import com.eagskunst.libraries.movieapp.utils.Constants
import com.eagskunst.libraries.movieapp.utils.base.BaseActivity
import com.kinesis.kinesisapp.utils.base.ScreenState
import javax.inject.Inject

class MovieDetailActivity : BaseActivity(), MovieDetailCallback {

    lateinit var binding: ActivityMovieDetailBinding
    @Inject lateinit var viewModelFactory: ViewModelFactory<MovieDetailViewModel>
    private val controller: MovieDetailController by lazy { MovieDetailController(this) }
    private val viewModel by viewModels<MovieDetailViewModel> { viewModelFactory }

    override fun initComponent(appComponent: MovieAppComponent) {
        DaggerMovieDetailComponent.builder()
            .movieAppComponent(appComponent)
            .build()
            .inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initComponent(MoviesApp.appInstance.appComponent)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_movie_detail)
        binding.lifecycleOwner = this
        binding.controller = controller
        binding.viewModel = viewModel
    }

    override fun onStart() {
        super.onStart()

        viewModel.mutableScreenState.observe(this, Observer {
            if(it != null && it == ScreenState.ERROR){
                showSnackErrorWithAction(R.string.try_again){
                    getMovieDetail()
                }
            }
        })

        viewModel.movieLiveData.observe(this, Observer {
            if(it != null){
                controller.setData(it)
            }
        })

        getMovieDetail()
    }

    private fun getMovieDetail(){
        val movie = intent.getParcelableExtra<Movie>(Constants.MOVIE_EXTRA)
        if(movie != null){
            viewModel.updateMovie(movie)
        }
        else{
            val id = intent.getIntExtra(Constants.MOVIE_ID, 0)
            viewModel.getMovieAndCast(id)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }

    override fun onBackButtonCallback() = onBackPressed()

    override fun onFavoriteCallback(movie: Movie, isFavorite: Boolean) {
        viewModel.updateMovie(movie, isFavorite)
    }
}
