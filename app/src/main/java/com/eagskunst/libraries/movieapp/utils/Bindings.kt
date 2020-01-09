package com.eagskunst.libraries.movieapp.utils

import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.EpoxyRecyclerView
import com.eagskunst.libraries.movieapp.app.models.CategoryCard
import com.eagskunst.libraries.movieapp.utils.enums.Grid
import com.eagskunst.libraries.movieapp.utils.enums.LayoutManagerTypes
import com.eagskunst.libraries.movieapp.utils.enums.Linear
import com.eagskunst.libraries.movieapp.utils.views.MovieProgressView
import com.kinesis.kinesisapp.utils.base.ScreenState
import com.skydoves.rainbow.Rainbow
import com.skydoves.rainbow.RainbowOrientation
import com.skydoves.rainbow.contextColor

/**
 * Created by eagskunst in 30/11/2019.
 */

@BindingAdapter("app:cardGradient")
fun applyRainbowGradient(view: View, model: CategoryCard){
    Rainbow(view).palette {
        model.colors.forEach { +contextColor(it) }
    }.background(
        orientation = RainbowOrientation.LEFT_RIGHT,
        radius = if (view is CardView) view.radius.toInt() / 2 else 0
    )
}

@BindingAdapter("app:loadImage")
fun loadImageWithGlide(view: ImageView, url: String?) = view.loadImageWithGlide(url)

@BindingAdapter("app:attachEpoxyController")
fun attachEpoxyController(epoxyRv: EpoxyRecyclerView, controller: EpoxyController) =
    epoxyRv.setController(controller)

@BindingAdapter("app:epoxyLayoutManager")
fun setLayoutManager(epoxyRv: EpoxyRecyclerView, layoutType: LayoutManagerTypes) {
    when (layoutType) {
        Grid -> epoxyRv.layoutManager = GridLayoutManager(epoxyRv.context, 2)
        Linear -> {//Default already is Linear}
        }
    }
}

@BindingAdapter("app:screenStateVisibility")
fun changeVisibilityWithScreenState(movieProgressView: MovieProgressView, screenState: ScreenState){
    movieProgressView.visibility = if(screenState == ScreenState.LOADING) View.VISIBLE
    else View.GONE
}
