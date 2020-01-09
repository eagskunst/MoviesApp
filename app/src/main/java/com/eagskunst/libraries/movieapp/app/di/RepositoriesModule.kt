package com.eagskunst.libraries.movieapp.app.di

import com.eagskunst.libraries.movieapp.app.app_di.MovieAppScope
import com.eagskunst.libraries.movieapp.app.network.api.MovieDetailApi
import com.eagskunst.libraries.movieapp.app.network.api.MovieListApi
import com.eagskunst.libraries.movieapp.ui.movie_detail.mvvm.MovieDetailLocalRepository
import com.eagskunst.libraries.movieapp.ui.movie_detail.mvvm.MovieDetailRemoteRepository
import com.eagskunst.libraries.movieapp.ui.movie_detail.mvvm.MovieDetailRepository
import com.eagskunst.libraries.movieapp.ui.movie_detail.mvvm.MovieDetailRepositoryImpl
import com.eagskunst.libraries.movieapp.ui.movie_list.mvvm.MovieListLocalRepository
import com.eagskunst.libraries.movieapp.ui.movie_list.mvvm.MovieListRemoteRepository
import com.eagskunst.libraries.movieapp.ui.movie_list.mvvm.MovieListRepository
import com.eagskunst.libraries.movieapp.ui.movie_list.mvvm.MovieListRepositoryImpl
import dagger.Module
import dagger.Provides

/**
 * Created by eagskunst in 30/11/2019.
 */
@Module
class RepositoriesModule {

    @Provides
    @MovieAppScope
    fun movieListLocalRepo(): MovieListRepository.LocalRepository = MovieListLocalRepository()

    @Provides
    @MovieAppScope
    fun movieListRemoteRepo(movieListApi: MovieListApi): MovieListRepository.RemoteRepository =
        MovieListRemoteRepository(movieListApi)

    @Provides
    @MovieAppScope
    fun movieListRepo(remoteRepository: MovieListRepository.RemoteRepository,
                      localRepository: MovieListRepository.LocalRepository): MovieListRepository =
        MovieListRepositoryImpl(remoteRepository, localRepository)

    @Provides
    @MovieAppScope
    fun movieDetailLocalRepo(): MovieDetailRepository.LocalRepository = MovieDetailLocalRepository()

    @Provides
    @MovieAppScope
    fun movieDetailRemoteRepo(movieDetailApi: MovieDetailApi): MovieDetailRepository.RemoteRepository = MovieDetailRemoteRepository(movieDetailApi)

    @Provides
    @MovieAppScope
    fun movieDetailRepo(remoteRepository: MovieDetailRepository.RemoteRepository,
                        localRepository: MovieDetailRepository.LocalRepository): MovieDetailRepository =
        MovieDetailRepositoryImpl(remoteRepository, localRepository)
}