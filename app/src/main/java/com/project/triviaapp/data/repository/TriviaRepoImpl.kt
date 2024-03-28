package com.project.triviaapp.data.repository

import com.project.triviaapp.data.datasource.CategoriesResponse
import com.project.triviaapp.data.datasource.CategoryDto
import com.project.triviaapp.data.datasource.QuestionDto
import com.project.triviaapp.data.datasource.QuestionResponse
import com.project.triviaapp.data.datasource.TriviaApi
import com.project.triviaapp.di.NetworkModule
import com.project.triviaapp.domain.repository.TriviaRepo


class TriviaRepoImpl(
    private val api: TriviaApi = NetworkModule.provideTriviaApi()
): TriviaRepo {

    private var cachedCategories = listOf<CategoryDto>()
    private var cachedQuestions = listOf<QuestionDto>()
    override suspend fun getCategories(): CategoriesResponse {
        try {
            val response = api.getCategories()
            cachedCategories = response.categories
            return  response
        } catch (e: Exception){
            e.printStackTrace()
            throw e
        }
    }

    override suspend fun getQuestion(
        difficulty: String,
        type: String?,
        category: Int?
    ): QuestionResponse {
        try {
            val response = api.getQuestion(
                category = category,
                difficulty = difficulty,
                type = type
            )
            cachedQuestions = response.question
            return response
        } catch (e: Exception) {
            e.printStackTrace()
            throw e
        }
    }

    override fun getCategoryId(id: Int): CategoryDto? {
        return cachedCategories.firstOrNull{
            it.id == id
        }
    }

    companion object {
        @Volatile
        private var instance: TriviaRepoImpl? = null

        fun getInstance() = instance?: synchronized(this) {
            instance ?: TriviaRepoImpl().also { instance = it }
        }
    }
}
