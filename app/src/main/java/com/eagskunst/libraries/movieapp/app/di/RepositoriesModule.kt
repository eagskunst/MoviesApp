package com.eagskunst.libraries.movieapp.app.di

import com.eagskunst.libraries.movieapp.app.network.api.MovieListApi
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
    fun movieListLocalRepo(): MovieListRepository.LocalRepository = MovieListLocalRepository()

    @Provides
    fun movieListRemoteRepo(movieListApi: MovieListApi): MovieListRepository.RemoteRepository =
        MovieListRemoteRepository(movieListApi)

    @Provides
    fun movieListRepo(remoteRepository: MovieListRepository.RemoteRepository,
                      localRepository: MovieListRepository.LocalRepository): MovieListRepository =
        MovieListRepositoryImpl(remoteRepository, localRepository)
}