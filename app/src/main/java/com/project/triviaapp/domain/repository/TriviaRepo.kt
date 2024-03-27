package com.project.triviaapp.domain.repository

import com.project.triviaapp.data.datasource.CategoriesResponse
import com.project.triviaapp.data.datasource.CategoryDto
import com.project.triviaapp.data.datasource.QuestionDto
import com.project.triviaapp.domain.util.Resource

interface TriviaRepo {

    suspend fun getCategories(): CategoriesResponse
    suspend fun getQuestion(
        amount: Int,
        difficulty: String,
        type: String?,
        category: Int?,
    ): Resource<QuestionDto>

    fun getCategoryId(id: Int): CategoryDto?

}