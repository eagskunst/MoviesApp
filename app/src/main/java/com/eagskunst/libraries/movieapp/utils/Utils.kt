package com.eagskunst.libraries.movieapp.utils

import com.eagskunst.libraries.movieapp.app.MoviesApp

/**
 * Created by eagskunst in 30/11/2019.
 */

object Utils {

    fun getString(resource: Int) = MoviesApp.appContext.getString(resource)

    fun buildImageString(path: String) = "${Constants.BASE_IMG_URL}${path}"
}