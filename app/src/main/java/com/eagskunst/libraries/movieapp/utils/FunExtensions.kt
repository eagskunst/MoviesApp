package com.eagskunst.libraries.movieapp.utils

import android.content.Context
import android.content.ContextWrapper
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.airbnb.epoxy.CarouselModelBuilder
import com.airbnb.epoxy.EpoxyModel
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import java.util.regex.Pattern

/**
 * Created by eagskunst in 4/12/2019.
 * File to create extension functions to re-use code.
 */

fun String.isAnEmailAddress() : Boolean = Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun EditText.textString(): String = this.text.toString()

fun String.validPhoneNumber(): Boolean{
    return if (!Pattern.matches("[a-zA-Z]+", this)) {
        !(this.length < 6 || this.length > 13)
    } else {
        false
    }
}

fun ViewGroup.inflate(layout:Int): View {
    return LayoutInflater.from(context).inflate(layout,this, false)
}

fun Context.inflateView(layout: Int): View {
    val inflater = this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    return inflater.inflate(layout, null)
}

fun Context.inflateCustomView(layout: Int, viewGroup: ViewGroup?) {
    val inflater= this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    inflater.inflate(layout, viewGroup, true)
}

fun ViewGroup.setLayoutChangeAnim(layoutChange: Int){
    this.layoutTransition.enableTransitionType(layoutChange)
}

fun BottomNavigationView.getSelectedItem() = menu.findItem(selectedItemId)

fun BottomNavigationView.getMenuItem(id: Int) = menu.findItem(id)

fun View.getParentActivity(): AppCompatActivity? = this.context.getParentActivity()

fun Context.getParentActivity(): AppCompatActivity? {
    return when (this) {
        is AppCompatActivity -> this
        is ContextWrapper -> this.baseContext.getParentActivity()
        else -> null
    }
}

fun Fragment.longToast(msg: String) {
    Toast.makeText(requireContext(), msg, Toast.LENGTH_LONG).show()
}

fun Fragment.longToast(msg: Int) {
    Toast.makeText(requireContext(), msg, Toast.LENGTH_LONG).show()
}

fun AppCompatActivity.longToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}

fun View.snackbar(msg: Int) = Snackbar.make(this, msg, Snackbar.LENGTH_SHORT)
fun View.snackbar(msg: String) = Snackbar.make(this, msg, Snackbar.LENGTH_SHORT)
fun View.longSnackbar(msg: String) = Snackbar.make(this, msg, Snackbar.LENGTH_LONG)
fun View.longSnackbar(msg: Int) = Snackbar.make(this, msg, Snackbar.LENGTH_LONG)



fun AppCompatActivity.longToast(msg: Int) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}

fun ImageView.loadImageWithGlide(imgUrl: String?){
    imgUrl?.let {
        Glide.with(this.context)
            .load(imgUrl)
            .into(this)
    }
}

//From Epoxy Wiki
inline fun <T> CarouselModelBuilder.withModelsFrom(items: List<T>, modelBuilder: (T) -> EpoxyModel<*>){
    models(items.map { modelBuilder(it) })
}