package com.project.triviaapp.domain.repository

import com.project.triviaapp.data.datasource.QuestionDto
import com.project.triviaapp.domain.trivia.CategoryInfo
import com.project.triviaapp.domain.util.Resource

interface TriviaRepo {

    suspend fun getCategories(): Resource<CategoryInfo>
    suspend fun getQuestion(
        amount: Int,
        difficulty: String,
        type: String?,
        category: Int?,
    ): Resource<QuestionDto>

}