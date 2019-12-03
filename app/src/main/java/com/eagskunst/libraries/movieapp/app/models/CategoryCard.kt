package com.eagskunst.libraries.movieapp.app.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by eagskunst in 1/12/2019.
 */
@Parcelize
data class CategoryCard(val id: Int,
                        val title: String = "",
                        val colors: List<Int> = listOf(),
                        val img: Int = 0) : Parcelable