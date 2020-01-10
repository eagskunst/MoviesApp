package com.eagskunst.libraries.movieapp.app.network.adapters

import com.eagskunst.libraries.movieapp.app.models.Actor
import com.eagskunst.libraries.movieapp.app.models.Movie
import com.eagskunst.libraries.movieapp.app.models.MovieCard
import com.eagskunst.libraries.movieapp.app.models.MovieWrapper
import com.eagskunst.libraries.movieapp.app.network.models.movie_detail.ActorResponse
import com.eagskunst.libraries.movieapp.app.network.models.movie_detail.MovieDetailResponse
import com.eagskunst.libraries.movieapp.app.network.models.movie_list.MovieListResponse
import com.eagskunst.libraries.movieapp.app.network.models.movie_list.MovieShortDetail
import com.eagskunst.libraries.movieapp.db.entities.ActorEntity
import com.eagskunst.libraries.movieapp.db.entities.MovieEntity
import com.eagskunst.libraries.movieapp.db.entities.MovieWithActors
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

    private fun fromActorResponseToActor(actorResponse: ActorResponse, movieId: Int): Actor {
        return with(actorResponse){
            Actor(
                id = id,
                name = name,
                photoUrl = Utils.buildImageString(profilePath ?: ""),
                movieId = movieId
            )
        }
    }

    fun fromActorResponseListToActorList(list: List<ActorResponse>?, movieId: Int): List<Actor>? =
        list?.map { fromActorResponseToActor(it, movieId) }

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
        val actors = fromActorResponseListToActorList(movieDetailResponse.credits?.cast, movieDetailResponse.id)
        val studio = getStudioFromMovieDetailResponse(movieDetailResponse)
        val genres = getGenresFromMovieDetailResponse(movieDetailResponse)

        return with(movieDetailResponse){
            Movie(
                id = id,
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

    private fun actorToActorEntity(actor: Actor) =
        ActorEntity(id = actor.id, name = actor.name, photoUrl = actor.photoUrl, movieId = actor.movieId)

    private fun actorEntityToActor(actor: ActorEntity) =
        Actor(id = actor.id, name = actor.name, photoUrl = actor.photoUrl, movieId = actor.movieId)

    private fun movieToMovieEntity(movie: Movie) =
        with(movie){
            MovieEntity(id = id, photoUrl = photoUrl, name = name, releaseDate = releaseDate,
                genres = genres, studio = studio, rating = rating, description = description, isFavorite = isFavorite)
        }

    private fun movieEntityToMovie(movie: MovieEntity) =
        with(movie){
            Movie(id = id, photoUrl = photoUrl, name = name, releaseDate = releaseDate,
                genres = genres, studio = studio, rating = rating, description = description, isFavorite = isFavorite,
                actors = null)
        }

    fun movieToMovieWrapper(movie: Movie): MovieWrapper{
        val actors = movie.actors?.map { actorToActorEntity(it) } ?: listOf()
        val movieEntity = movieToMovieEntity(movie)
        return MovieWrapper(movieEntity, actors)
    }

    fun movieWithActorsToMovie(movieWithActors: MovieWithActors): Movie {
        val actors = movieWithActors.actors.map { actorEntityToActor(it) }
        val movie = movieEntityToMovie(movieWithActors.movie)
        return movie.copy(actors = actors)
    }
}