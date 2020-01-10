package com.eagskunst.libraries.movieapp.app.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by eagskunst in 8/12/2019.
 */

@Parcelize
data class Actor(val id: Int,
                 val name: String?,
                 val photoUrl: String?,
                 val movieId: Int
                 ) : Parcelable