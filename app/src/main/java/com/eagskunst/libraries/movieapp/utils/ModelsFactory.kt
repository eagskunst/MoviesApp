package com.eagskunst.libraries.movieapp.utils

import com.eagskunst.libraries.movieapp.R
import com.eagskunst.libraries.movieapp.app.models.Actor
import com.eagskunst.libraries.movieapp.app.models.CategoryCard
import com.eagskunst.libraries.movieapp.app.models.Movie
import com.eagskunst.libraries.movieapp.app.models.MovieCard
import kotlin.random.Random

/**
 * Created by eagskunst in 1/12/2019.
 */
object ModelsFactory {

    fun createCategoriesModels(): List<CategoryCard>{
        return listOf(
            CategoryCard(
                title = "Because you watched",
                img = R.drawable.movie_bg,
                colors = listOf(
                    R.color.colorGradient1,
                    R.color.colorGradient2
                ),
                id = 1
            ),
            CategoryCard(
                title = "Trending now",
                img = R.drawable.movie_bg,
                colors = listOf(
                    R.color.colorGradient3,
                    R.color.colorGradient4
                ),
                id = 2
            ),
            CategoryCard(
                title = "Top picks",
                img = R.drawable.movie_bg,
                colors = listOf(
                    R.color.colorGradient5,
                    R.color.colorGradient6
                ),
                id = 3
            ),
            CategoryCard(
                title = "Popular",
                img = R.drawable.movie_bg,
                colors = listOf(
                    R.color.colorGradient7,
                    R.color.colorGradient8
                ),
                id = 4
            )
        )
    }

    fun createMoviesModels(): List<MovieCard> {
        return listOf(
            MovieCard(
                id = 0,
                imgUrl = "https://i.pinimg.com/originals/fd/5e/66/fd5e662dce1a3a8cd192a5952fa64f02.jpg"
            ),
            MovieCard(
                id = 1,
                imgUrl = "https://www.washingtonpost.com/graphics/2019/entertainment/oscar-nominees-movie-poster-design/img/black-panther-web.jpg"
            ),
            MovieCard(
                id = 2,
                imgUrl = "https://cdn.pastemagazine.com/www/system/images/photo_albums/best-movie-posters-2016/large/moonlight-ver2-xlg.jpg?1384968217"
            ),
            MovieCard(
                id = 3,
                imgUrl = "https://d13ezvd6yrslxm.cloudfront.net/wp/wp-content/images/2017-bestposter-starwarslastjedi.jpg"
            ),
            MovieCard(
                id = 4,
                imgUrl = "https://i.pinimg.com/originals/ac/2f/58/ac2f58d9275e2399279c1fda4220178c.jpg"
            ),
            MovieCard(
                id = 5,
                imgUrl = "https://www.joblo.com/assets/images/joblo/posters/2019/05/beats_vertical-main_rgb_pre.jpg"
            ),
            MovieCard(
                id = 6,
                imgUrl = "https://images-na.ssl-images-amazon.com/images/I/91kjict1BpL._SL1500_.jpg"
            ),
            MovieCard(
                id = 7,
                imgUrl = "https://cinesunidosweb.blob.core.windows.net/poster/HO00003957.jpg"
            )
        )
    }

    fun createFakeMovie() : Movie {
        return Movie(
            id = Random.nextInt().toString(),
            name = "Aquaman",
            rating = 4f,
            studio = "Warner Bros",
            genres = "Action, Adventure, Fantasy",
            releaseDate = "21/06/2018",
            actors = (0..6).map { createFakeActor(it) },
            photoUrl = "https://images-na.ssl-images-amazon.com/images/I/A1t7EBA+qvL._RI_.jpg",
            description = "In 1985 Maine, lighthouse keeper Thomas Curry rescues Atlanna, the queen of the underwater nation of Atlantis, during a storm. They eventually fall in love and have a son named Arthur, who is born with the power to communicate with marine lifeforms."
        )
    }

    fun createFakeActor(id: Any): Actor = Actor(
        id = id.toString(),
        name = "Leonardo DiCaprio",
        photoUrl = "https://upload.wikimedia.org/wikipedia/commons/4/46/Leonardo_Dicaprio_Cannes_2019.jpg"
    )
}