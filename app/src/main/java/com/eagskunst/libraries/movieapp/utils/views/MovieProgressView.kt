package com.eagskunst.libraries.movieapp.utils.views

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.eagskunst.libraries.movieapp.R
import com.eagskunst.libraries.movieapp.utils.inflateCustomView

/**
 * Created by eagskunst in 8/1/2020.
 */

class MovieProgressView  @JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0): FrameLayout(context, attrs, defStyleAttr){

    init {
        context.inflateCustomView(R.layout.movie_progress_view, this)
    }
}