package com.eagskunst.libraries.movieapp.utils.base

import com.eagskunst.libraries.movieapp.app.MoviesApp


/**
 * Created by eagskunst in 1/12/2019.
 */
abstract class BaseLocalRepository {
    protected val database = MoviesApp.appInstance.database
}