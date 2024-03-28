package com.project.triviaapp.di

import com.project.triviaapp.data.datasource.TriviaApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideTriviaApi(): TriviaApi {
        return Retrofit.Builder()
            .baseUrl("https://opentdb.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

}