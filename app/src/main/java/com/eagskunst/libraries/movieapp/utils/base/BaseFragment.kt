package com.eagskunst.libraries.movieapp.utils.base

import android.view.View
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.navOptions
import com.eagskunst.libraries.movieapp.R
import com.eagskunst.libraries.movieapp.app.app_di.MovieAppComponent
import com.eagskunst.libraries.movieapp.utils.Utils
import com.eagskunst.libraries.movieapp.utils.longSnackbar
import com.eagskunst.libraries.movieapp.utils.snackbar


/**
 * Created by eagskunst in 3/9/2019.
 */
abstract class BaseFragment : Fragment {

    protected val unknownErrorMessage: String by lazy {
        Utils.getString(R.string.unknown_error)
    }
    protected val timeoutErrorMessage: String by lazy {
        Utils.getString(R.string.try_again)
    }
    protected val noInternetError: String by lazy {
        Utils.getString(R.string.no_internet)
    }

    protected var fragmentView: View? = null

    constructor() : super()
    constructor(@LayoutRes layout: Int) : super(layout)
    protected abstract fun initComponent(appComponent: MovieAppComponent)


    override fun onDestroyView() {
        super.onDestroyView()
        fragmentView = null
    }

    fun showSnackError(msg: String, long: Boolean = false) {
        val snack = if (!long) fragmentView?.snackbar(msg)
        else fragmentView?.longSnackbar(msg)
        snack?.view?.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.colorRedError
            )
        )
        val textView =
            snack?.view?.findViewById(com.google.android.material.R.id.snackbar_text) as TextView //Get reference of snackbar textview
        textView.maxLines = 5
    }

    fun showSnackError(msg: Int, long: Boolean = false) {
        val snack = if (!long) fragmentView?.snackbar(msg)
        else fragmentView?.longSnackbar(msg)
        snack?.view?.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.colorRedError
            )
        )
        val textView =
            snack?.view?.findViewById(com.google.android.material.R.id.snackbar_text) as TextView //Get reference of snackbar textview
        textView.maxLines = 5
    }

    fun showSnackSuccess(msg: String, long: Boolean = false) {
        val snack = if (!long) fragmentView?.snackbar(msg)
        else fragmentView?.longSnackbar(msg)
        snack?.view?.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.colorSuccess
            )
        )
    }

    fun showSnackSuccess(msg: Int, long: Boolean = false) {
        val snack = if (!long) fragmentView?.snackbar(msg)
        else fragmentView?.longSnackbar(msg)
        snack?.view?.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.colorSuccess
            )
        )
    }

    fun showErrorMessage(errorType: ErrorType) {
        when (errorType) {
            ErrorType.NETWORK -> showSnackError(noInternetError)
            ErrorType.TIMEOUT -> showSnackError(timeoutErrorMessage)
            ErrorType.UNKNOWN -> showSnackError(unknownErrorMessage)
            ErrorType.SESSION_EXPIRED -> {}
        }
    }

    protected fun getDefaultNavOptions(fade: Boolean = false) = navOptions {
        if (!fade) {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popExit = R.anim.slide_out_right
                popEnter = R.anim.slide_in_left
            }
        } else {
            anim {
                enter = R.anim.fade_in
                exit = R.anim.fade_out
                popExit = R.anim.fade_out
                popEnter = R.anim.fade_in
            }
        }
    }

}