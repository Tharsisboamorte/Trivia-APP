package com.project.triviaapp.di

import com.project.triviaapp.data.repository.TriviaRepoImpl
import com.project.triviaapp.domain.repository.TriviaRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton


@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindTriviaRepository(
        triviaRepoImpl: TriviaRepoImpl
    ): TriviaRepo
}