package com.eagskunst.libraries.movieapp.utils

import android.util.Log
import androidx.databinding.BindingAdapter
import com.eagskunst.libraries.movieapp.app.models.CategoryCard
import com.google.android.material.card.MaterialCardView
import com.skydoves.rainbow.Rainbow
import com.skydoves.rainbow.RainbowOrientation
import com.skydoves.rainbow.contextColor

/**
 * Created by eagskunst in 30/11/2019.
 */

@BindingAdapter("app:cardGradient")
fun applyRainbowGradient(view: MaterialCardView, model: CategoryCard){
    Log.d("Check", "Radius: ${view.radius.toInt() / 2}")
    Rainbow(view).palette {
        model.colors.forEach { +contextColor(it) }
    }.background(
        orientation = RainbowOrientation.LEFT_RIGHT,
        radius = view.radius.toInt() / 2
    )
}