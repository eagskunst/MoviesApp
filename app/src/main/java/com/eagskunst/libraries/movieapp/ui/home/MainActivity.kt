package com.eagskunst.libraries.movieapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityOptionsCompat
import androidx.databinding.DataBindingUtil
import com.eagskunst.libraries.movieapp.R
import com.eagskunst.libraries.movieapp.app.app_di.MovieAppComponent
import com.eagskunst.libraries.movieapp.app.models.CategoryCard
import com.eagskunst.libraries.movieapp.databinding.ActivityMainBinding
import com.eagskunst.libraries.movieapp.ui.movie_list.MovieListActivity
import com.eagskunst.libraries.movieapp.utils.Constants
import com.eagskunst.libraries.movieapp.utils.ModelsFactory
import com.eagskunst.libraries.movieapp.utils.base.BaseActivity
import com.eagskunst.libraries.movieapp.utils.enums.Grid
import androidx.core.util.Pair

class MainActivity : BaseActivity(), HomeItemClickListener {

    lateinit var binding: ActivityMainBinding
    private val myListCard = CategoryCard(
        title = "My list",
        colors = listOf(
            R.color.colorGradient4,
            R.color.colorRedError
        ),
        imgUrl = "https://images.unsplash.com/photo-1510827220565-c6a086ff31c8?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80",
        id = 0
    )

    override fun initComponent(appComponent: MovieAppComponent) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val homeController =
            HomeController()
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        binding.controller = homeController
        binding.myListCard = myListCard
        binding.layoutManagerType = Grid
        binding.imgUrl = Constants.FEATURED_MOVIE_IMG_URL
        binding.clickListener = View.OnClickListener { onItemClicked(it, myListCard)}

        homeController.setData(ModelsFactory.createCategoriesModels(), this)
    }

    override fun onItemClicked(view: View, model: CategoryCard) {
        val iv = view.findViewById<ImageView>(R.id.categoryIv)
        val tv = view.findViewById<TextView>(R.id.categoryTv)
        val pairsList = listOf<Pair<View, String>>(
            Pair(iv, Constants.TRANSITION_CATEGORY_IMAGE_IV),
            Pair(tv, Constants.TRANSITION_CATEGORY_NAME_TV)
        )

        val actOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, pairsList[0], pairsList[1])
        val intent = Intent(this, MovieListActivity::class.java).apply {
            putExtra(Constants.CATEGORY_CARD_ID, model)
        }
        startActivity(intent, actOptions.toBundle())
    }

}
