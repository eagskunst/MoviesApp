package com.eagskunst.libraries.movieapp.utils.base

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.navOptions
import com.eagskunst.libraries.movieapp.R
import com.eagskunst.libraries.movieapp.app.app_di.MovieAppComponent
import com.eagskunst.libraries.movieapp.utils.Utils
import com.eagskunst.libraries.movieapp.utils.indefiniteSnackbar
import com.eagskunst.libraries.movieapp.utils.longSnackbar
import com.eagskunst.libraries.movieapp.utils.snackbar
import javax.inject.Inject

/**
 * Created by eagskunst in 3/9/2019.
 */
abstract class BaseActivity: AppCompatActivity {

    protected val unknownErrorMessage: String by lazy {
        Utils.getString(R.string.unknown_error)
    }
    protected val timeoutErrorMessage: String by lazy {
        Utils.getString(R.string.try_again)
    }
    protected val noInternetError: String by lazy {
        Utils.getString(R.string.no_internet)
    }

    private val mainView: View by lazy {
        findViewById<View>(android.R.id.content)
    }

    constructor():super()
    constructor(@LayoutRes layout: Int):super(layout)
    protected abstract fun initComponent(appComponent: MovieAppComponent)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun showSnackError(msg : String, long: Boolean = false){
        val snack = if(!long) mainView.snackbar(msg)
        else mainView.longSnackbar(msg)
        snack.view.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRedError))
    }

    fun showSnackError(msg : Int, long: Boolean = false){
        val snack = if(!long)mainView.snackbar(msg)
        else mainView.longSnackbar(msg)
        snack.view.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRedError))
    }

    fun showSnackErrorWithAction(msg: String, action: () -> Unit){
        val snackbar = mainView.indefiniteSnackbar(msg)
        snackbar.setAction(R.string.retry_text){ action() }
    }

    fun showSnackErrorWithAction(msg: Int, action: () -> Unit){
        val snackbar = mainView.indefiniteSnackbar(msg)
        snackbar.setAction(R.string.retry_text){ action() }
    }

    fun showSnackSuccess(msg : String, long: Boolean = false){
        val snack = if(!long)mainView.snackbar(msg)
        else mainView.longSnackbar(msg)
        val textView =
            snack.view.findViewById(com.google.android.material.R.id.snackbar_text) as TextView //Get reference of snackbar textview
        textView.maxLines = 5
        snack.view.setBackgroundColor(ContextCompat.getColor(this, R.color.colorSuccess))
    }

    fun showSnackSuccess(msg : Int, long: Boolean = false){
        val snack = if(!long)mainView.snackbar(msg)
        else mainView.longSnackbar(msg)
        snack.view.setBackgroundColor(ContextCompat.getColor(this, R.color.colorSuccess))
    }

    fun getDefaultNavOptions() = navOptions {
        anim {
            enter = android.R.anim.fade_in
            exit = android.R.anim.fade_out
            popExit = android.R.anim.fade_out
            popEnter = android.R.anim.fade_in
        }
    }

    fun showErrorMessage(errorType: ErrorType){
        when(errorType){
            ErrorType.NETWORK -> showSnackError(noInternetError)
            ErrorType.TIMEOUT -> showSnackError(timeoutErrorMessage)
            ErrorType.UNKNOWN -> showSnackError(unknownErrorMessage)
            ErrorType.SESSION_EXPIRED -> {}
        }
    }
}