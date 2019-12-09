package com.eagskunst.libraries.movieapp.ui.movie_list

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import com.eagskunst.libraries.movieapp.R
import com.eagskunst.libraries.movieapp.app.app_di.MovieAppComponent
import com.eagskunst.libraries.movieapp.databinding.ActivityMovieListBinding
import com.eagskunst.libraries.movieapp.ui.movie_detail.MovieDetailActivity
import com.eagskunst.libraries.movieapp.utils.Constants
import com.eagskunst.libraries.movieapp.utils.ModelsFactory
import com.eagskunst.libraries.movieapp.utils.base.BaseActivity
import com.eagskunst.libraries.movieapp.utils.enums.Grid
import kotlinx.android.synthetic.main.activity_movie_list.*

class MovieListActivity : BaseActivity() {

    private lateinit var binding: ActivityMovieListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val controller = MovieListController(this::onMovieCardClick)
            .apply { setData(ModelsFactory.createMoviesModels()) }


        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_list)

        binding.run {
            model = intent.getParcelableExtra(Constants.CATEGORY_CARD_ID)
            this.controller = controller
            navBtnClickListener  = View.OnClickListener {
                onBackPressed()
            }
            managerType = Grid
        }

        ViewCompat.setTransitionName(movieListBackgroundIv, Constants.TRANSITION_CATEGORY_IMAGE_IV)
        ViewCompat.setTransitionName(movieListTitleTv, Constants.TRANSITION_CATEGORY_NAME_TV)
    }
    override fun initComponent(appComponent: MovieAppComponent) {}

    private fun onMovieCardClick(id: Any){
        val intent = Intent(this, MovieDetailActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }
}
