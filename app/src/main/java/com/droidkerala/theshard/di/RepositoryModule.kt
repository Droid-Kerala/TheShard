package com.droidkerala.theshard.di

import com.droidkerala.theshard.data.repositoryimpl.MovieRepositoryImpl
import com.droidkerala.theshard.domain.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepository(impl: MovieRepositoryImpl): MovieRepository
}