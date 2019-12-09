package com.eagskunst.libraries.movieapp.ui.movie_detail

import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.epoxy.carousel
import com.eagskunst.libraries.movieapp.app.models.Movie
import com.eagskunst.libraries.movieapp.movieActor
import com.eagskunst.libraries.movieapp.movieDescription
import com.eagskunst.libraries.movieapp.movieHeader
import com.eagskunst.libraries.movieapp.movieMisc

/**
 * Created by eagskunst in 8/12/2019.
 */

class MovieDetailController(private val callbackListener: MovieDetailCallback)
    : TypedEpoxyController<Movie>(){

    companion object {
        const val MOVIE_HEADER_ID = "MovieHeader"
        const val MOVIE_DESCRIPTION_ID = "MovieDescription"
        const val MOVIE_MISCELANOUS = "MovieMisc"
    }

    override fun buildModels(data: Movie?) {
        data?.let { movie ->
            movieHeader {
                id(MOVIE_HEADER_ID)
                movie(movie)
                isSaved(false)
                backButtonClickListener { _, _, _, _ -> callbackListener.onBackButtonCallback() }
                likeButtonClickListener { _, _, _, _ -> callbackListener.onFavoriteCallback(movie) }
            }

            movieDescription {
                id(MOVIE_DESCRIPTION_ID)
                movie(movie)
            }

            carousel {
                movie.actors?.forEach {
                    movieActor {
                        id(it.id)
                        actor(it)
                    }
                }
            }

            movieMisc {
                id(MOVIE_MISCELANOUS)
                movie(movie)
            }
        }
    }

}


interface MovieDetailCallback {
    fun onBackButtonCallback()
    fun onFavoriteCallback(movie: Movie)
}