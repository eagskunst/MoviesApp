package com.eagskunst.libraries.movieapp.ui.home

import android.view.View
import com.eagskunst.libraries.movieapp.app.models.CategoryCard

/**
 * Created by eagskunst in 3/12/2019.
 */
interface HomeItemClickListener {
    fun onItemClicked(view: View, model: CategoryCard)
}