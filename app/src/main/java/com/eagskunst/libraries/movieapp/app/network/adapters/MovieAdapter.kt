package com.eagskunst.libraries.movieapp.app.network.adapters

import com.eagskunst.libraries.movieapp.app.models.MovieCard
import com.eagskunst.libraries.movieapp.app.network.models.movie_list.MovieListResponse
import com.eagskunst.libraries.movieapp.app.network.models.movie_list.MovieShortDetail
import com.eagskunst.libraries.movieapp.utils.Constants

/**
 * Created by eagskunst in 8/1/2020.
 */

class MovieAdapter {

    private fun fromMovieShortDetailToMovieCard(movieDetail: MovieShortDetail): MovieCard {
        with(movieDetail){
            return MovieCard(
                id = id,
                imgUrl = "${Constants.BASE_IMG_URL}${movieDetail.posterPath}"
            )
        }
    }

    fun fromMovieShortDetailListToMovieCardList(movieListResponse: MovieListResponse?): List<MovieCard>? =
        movieListResponse?.results?.map { fromMovieShortDetailToMovieCard(it) }

}