package com.project.triviaapp.di

import com.project.triviaapp.redux.ApplicationState
import com.project.triviaapp.redux.Store
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {
    @Provides
    @Singleton
    fun providesApplicationState(): Store<ApplicationState>{
        return Store(ApplicationState())
    }

}