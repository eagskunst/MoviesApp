package com.eagskunst.libraries.movieapp.ui.movie_detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.eagskunst.libraries.movieapp.R
import com.eagskunst.libraries.movieapp.app.models.Movie
import com.eagskunst.libraries.movieapp.databinding.ActivityMovieDetailBinding
import com.eagskunst.libraries.movieapp.utils.ModelsFactory

class MovieDetailActivity : AppCompatActivity(), MovieDetailCallback {

    lateinit var binding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_movie_detail)
        val controller = MovieDetailController(this)
        binding.controller = controller

        controller.setData(ModelsFactory.createFakeMovie())
    }

    override fun onBackButtonCallback() {

    }

    override fun onFavoriteCallback(movie: Movie) {
        Log.d("MovieDetailActivity", "Movie: $movie")
    }
}
