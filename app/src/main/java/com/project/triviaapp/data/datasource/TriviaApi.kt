package com.project.triviaapp.data.datasource

import retrofit2.http.GET
import retrofit2.http.Query

interface TriviaApi {

    @GET("https://opentdb.com/api_category.php")
    suspend fun getCategories(): TriviaDto

    @GET("https://opentdb.com/api.php?amount=1")
    suspend fun getQuestion(
        @Query("amount") amount: Int,
        @Query("difficulty") difficulty: String,
        @Query("type") type: String?,
        @Query("category") category: Int?,
    ) : QuestionDto

}