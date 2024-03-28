package com.project.triviaapp.domain.repository

import com.project.triviaapp.data.datasource.CategoriesResponse
import com.project.triviaapp.data.datasource.CategoryDto
import com.project.triviaapp.data.datasource.QuestionResponse

interface TriviaRepo {

    suspend fun getCategories(): CategoriesResponse
    suspend fun getQuestion(
        difficulty: String,
        type: String?,
        category: Int?,
    ): QuestionResponse

    fun getCategoryId(id: Int): CategoryDto?


}