package com.eagskunst.libraries.movieapp.app.network.adapters

import com.eagskunst.libraries.movieapp.app.models.Actor
import com.eagskunst.libraries.movieapp.app.models.Movie
import com.eagskunst.libraries.movieapp.app.models.MovieCard
import com.eagskunst.libraries.movieapp.app.network.models.movie_detail.ActorResponse
import com.eagskunst.libraries.movieapp.app.network.models.movie_detail.MovieDetailResponse
import com.eagskunst.libraries.movieapp.app.network.models.movie_list.MovieListResponse
import com.eagskunst.libraries.movieapp.app.network.models.movie_list.MovieShortDetail
import com.eagskunst.libraries.movieapp.utils.Utils

/**
 * Created by eagskunst in 8/1/2020.
 */

class MovieAdapter {

    private fun fromMovieShortDetailToMovieCard(movieDetail: MovieShortDetail): MovieCard {
        with(movieDetail){
            return MovieCard(
                id = id,
                imgUrl = Utils.buildImageString(posterPath ?: "")
            )
        }
    }

    fun fromMovieShortDetailListToMovieCardList(movieListResponse: MovieListResponse?): List<MovieCard>? =
        movieListResponse?.results?.map { fromMovieShortDetailToMovieCard(it) }

    private fun fromActorResponseToActor(actorResponse: ActorResponse): Actor {
        return with(actorResponse){
            Actor(
                id = id,
                name = name,
                photoUrl = Utils.buildImageString(profilePath ?: "")
            )
        }
    }

    fun fromActorResponseListToActorList(list: List<ActorResponse>?): List<Actor>? =
        list?.map { fromActorResponseToActor(it) }

    private fun getGenresFromMovieDetailResponse(movieDetailResponse: MovieDetailResponse?): String? {
        val builder = StringBuilder()
        movieDetailResponse?.genres?.forEach {
            it?.name?.let { name -> builder.append("$name, ") }
        }
        return builder.removeRange(builder.length - 2, builder.length).toString()
    }

    private fun getStudioFromMovieDetailResponse(movieDetailResponse: MovieDetailResponse?) =
        if(movieDetailResponse?.productionCompanies?.isNotEmpty() == true)
            movieDetailResponse.productionCompanies[0]?.name
        else
            null

    fun fromMovieDetailResponseToMovie(movieDetailResponse: MovieDetailResponse?): Movie? {
        if(movieDetailResponse == null) return null
        val actors = fromActorResponseListToActorList(movieDetailResponse.credits?.cast)
        val studio = getStudioFromMovieDetailResponse(movieDetailResponse)
        val genres = getGenresFromMovieDetailResponse(movieDetailResponse)

        return with(movieDetailResponse){
            Movie(
                id = id.toString(),
                photoUrl = Utils.buildImageString(posterPath ?: ""),
                name = originalTitle,
                description = overview,
                actors = actors,
                rating = voteAverage?.toFloat() ?: 0f,
                studio = studio,
                genres = genres,
                releaseDate = releaseDate
            )
        }
    }
}