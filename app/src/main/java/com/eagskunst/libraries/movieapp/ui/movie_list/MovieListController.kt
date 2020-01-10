package com.eagskunst.libraries.movieapp.ui.movie_list

import com.airbnb.epoxy.TypedEpoxyController
import com.eagskunst.libraries.movieapp.app.models.MovieCard
import com.eagskunst.libraries.movieapp.movieCard

/**
 * Created by eagskunst in 3/12/2019.
 */
class MovieListController(val onMovieClick:(id: MovieCard) -> Unit)
    : TypedEpoxyController<List<MovieCard>>() {

    override fun buildModels(data: List<MovieCard>?) {

        data?.forEach {
            movieCard {
                id(it.id)
                movieCard(it)
                clickListener { _, _, _, _ -> onMovieClick(it) }
            }
        }
    }

}