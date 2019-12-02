package com.eagskunst.libraries.movieapp.utils

import com.eagskunst.libraries.movieapp.R
import com.eagskunst.libraries.movieapp.app.models.CategoryCard

/**
 * Created by eagskunst in 1/12/2019.
 */
object ModelsFactory {

    fun createCategoriesModels(): List<CategoryCard>{
        return listOf(
            CategoryCard(
                title = "Because you watched",
                img = R.drawable.movie_bg,
                colors = listOf(
                    R.color.colorGradient1,
                    R.color.colorGradient2
                )
            ),
            CategoryCard(
                title = "Trending now",
                img = R.drawable.movie_bg,
                colors = listOf(
                    R.color.colorGradient3,
                    R.color.colorGradient4
                )
            ),
            CategoryCard(
                title = "Top picks",
                img = R.drawable.movie_bg,
                colors = listOf(
                    R.color.colorGradient5,
                    R.color.colorGradient6
                )
            ),
            CategoryCard(
                title = "Popular",
                img = R.drawable.movie_bg,
                colors = listOf(
                    R.color.colorGradient7,
                    R.color.colorGradient8
                )
            )
        )
    }
}