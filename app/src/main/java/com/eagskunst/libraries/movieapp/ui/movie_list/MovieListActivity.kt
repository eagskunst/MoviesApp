package com.eagskunst.libraries.movieapp.ui.movie_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import androidx.transition.TransitionInflater
import com.eagskunst.libraries.movieapp.R
import com.eagskunst.libraries.movieapp.app.models.CategoryCard
import com.eagskunst.libraries.movieapp.databinding.ActivityMovieListBinding
import com.eagskunst.libraries.movieapp.utils.Constants
import com.eagskunst.libraries.movieapp.utils.Utils
import com.skydoves.rainbow.Rainbow
import com.skydoves.rainbow.RainbowOrientation
import com.skydoves.rainbow.contextColor
import kotlinx.android.synthetic.main.activity_movie_list.*

class MovieListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_list)
        binding.model = intent.getParcelableExtra(Constants.CATEGORY_CARD_ID)
        binding.navBtnClickListener = View.OnClickListener {
            onBackPressed()
        }

        ViewCompat.setTransitionName(movieListBackgroundIv, Constants.TRANSITION_CATEGORY_IMAGE_IV)
        ViewCompat.setTransitionName(movieListTitleTv, Constants.TRANSITION_CATEGORY_NAME_TV)

    }
}
