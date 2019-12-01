package com.eagskunst.libraries.movieapp.app.interceptor

import com.eagskunst.libraries.movieapp.R
import com.eagskunst.libraries.movieapp.utils.Utils
import java.io.IOException

class NoConnectivityException : IOException() {
    override val message: String?
        get() = Utils.getString(R.string.connectivity_exception)
}
