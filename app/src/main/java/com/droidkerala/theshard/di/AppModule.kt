package com.droidkerala.theshard.di

import com.droidkerala.theshard.data.datasources.IMovieDataSource
import com.droidkerala.theshard.data.datasources.IMovieLocalDataSource
import com.droidkerala.theshard.data.datasources.MovieDataSource
import com.droidkerala.theshard.data.datasources.MovieLocalDataSource
import com.droidkerala.theshard.data.network.ApiService
import com.droidkerala.theshard.data.repositoryimpl.MovieRepositoryImpl
import com.droidkerala.theshard.domain.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module(includes = [ NetworkModule::class])

class AppModule {

    @Provides
    @Singleton
    fun bindRepository(local : IMovieLocalDataSource, remote : IMovieDataSource): MovieRepository{
        return MovieRepositoryImpl(remote,local)
    }

    @Provides
    @Singleton
    fun bindLocalDataSource(): IMovieLocalDataSource{
        return MovieLocalDataSource()
    }

    @Provides
    @Singleton
    fun bindRemoteDataSource(apiService : ApiService): IMovieDataSource{
        return MovieDataSource(apiService)
    }
}