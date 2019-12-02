package com.eagskunst.libraries.movieapp

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.eagskunst.libraries.movieapp.app.app_di.MovieAppComponent
import com.eagskunst.libraries.movieapp.utils.ModelsFactory
import com.eagskunst.libraries.movieapp.utils.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    val cardsItems = ModelsFactory.createCategoriesModels()

    override fun initComponent(appComponent: MovieAppComponent) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gridLayoutManager = GridLayoutManager(this, 2)
        dummyRv.layoutManager = gridLayoutManager

        dummyRv.withModels {
            cardsItems.forEach {
                gradientCard {
                    id(it.hashCode())
                    model(it)
                }
            }
        }
    }
}
