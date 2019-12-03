package com.eagskunst.libraries.movieapp

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.eagskunst.libraries.movieapp.app.app_di.MovieAppComponent
import com.eagskunst.libraries.movieapp.app.models.CategoryCard
import com.eagskunst.libraries.movieapp.databinding.ActivityMainBinding
import com.eagskunst.libraries.movieapp.utils.ModelsFactory
import com.eagskunst.libraries.movieapp.utils.base.BaseActivity
import com.eagskunst.libraries.movieapp.utils.enums.Grid

class MainActivity : BaseActivity() {

    lateinit var binding: ActivityMainBinding
    private val myListCard = CategoryCard(
        title = "My list",
        colors = listOf(
            R.color.colorGradient4,
            R.color.colorRedError
        ),
        img = R.drawable.mylist_bg
    )

    override fun initComponent(appComponent: MovieAppComponent) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val homeController = HomeController()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.controller = homeController
        binding.myListCard = myListCard
        binding.layoutManagerType = Grid

        homeController.setData(ModelsFactory.createCategoriesModels())
    }
}
