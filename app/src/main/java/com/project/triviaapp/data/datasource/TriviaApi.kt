package com.project.triviaapp.data.datasource

import retrofit2.http.GET
import retrofit2.http.Query

interface TriviaApi {

    @GET("api_category.php")
    suspend fun getCategories(): CategoriesResponse

    @GET("api.php?amount=1&")
    suspend fun getQuestion(
        @Query("difficulty") difficulty: String,
        @Query("type") type: String?,
        @Query("category") category: Int?,
    ) : QuestionResponse

}