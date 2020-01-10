package com.eagskunst.libraries.movieapp.ui.movie_detail

import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.epoxy.carousel
import com.eagskunst.libraries.movieapp.*
import com.eagskunst.libraries.movieapp.app.models.Movie
import com.eagskunst.libraries.movieapp.utils.withModelsFrom

/**
 * Created by eagskunst in 8/12/2019.
 */

class MovieDetailController(private val callbackListener: MovieDetailCallback)
    : TypedEpoxyController<Movie>(){

    companion object {
        const val MOVIE_HEADER_ID = "MovieHeader"
        const val MOVIE_DESCRIPTION_ID = "MovieDescription"
        const val MOVIE_ACTORS_CAROUSEL = "MovieActorsCarousel"
        const val MOVIE_MISCELLANEOUS = "MovieMisc"
    }

    private var isFavorite: Boolean = false

    override fun buildModels(data: Movie?) {
        isFavorite = data?.isFavorite ?: false
        data?.let { movie ->
            movieHeader {
                id(MOVIE_HEADER_ID)
                movie(movie)
                isSaved(movie.isFavorite)
                backButtonClickListener { _, _, _, _ -> callbackListener.onBackButtonCallback() }
                likeButtonClickListener { _, _, _, _ ->
                    callbackListener.onFavoriteCallback(movie, isFavorite)
                    isFavorite = !isFavorite
                }
            }

            movieDescription {
                id(MOVIE_DESCRIPTION_ID)
                movie(movie)
            }

            movie.actors?.let { list ->
                carousel {
                    id(MOVIE_ACTORS_CAROUSEL)
                    withModelsFrom(list) {
                        MovieActorBindingModel_()
                            .id(it.id)
                            .actor(it)
                    }
                }
            }

            movieMisc {
                id(MOVIE_MISCELLANEOUS)
                movie(movie)
            }
        }
    }

}


interface MovieDetailCallback {
    fun onBackButtonCallback()
    fun onFavoriteCallback(movie: Movie, isFavorite: Boolean)
}