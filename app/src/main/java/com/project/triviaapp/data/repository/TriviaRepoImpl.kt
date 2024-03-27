package com.project.triviaapp.data.repository

import com.project.triviaapp.data.datasource.CategoriesResponse
import com.project.triviaapp.data.datasource.CategoryDto
import com.project.triviaapp.data.datasource.QuestionDto
import com.project.triviaapp.data.datasource.TriviaApi
import com.project.triviaapp.di.AppModule
import com.project.triviaapp.domain.repository.TriviaRepo
import com.project.triviaapp.domain.util.Resource
import com.project.triviaapp.domain.util.Resource.Error
import com.project.triviaapp.domain.util.Resource.Success


class TriviaRepoImpl(
    private val api: TriviaApi = AppModule.provideTriviaApi()
): TriviaRepo {

    private var cachedCategories = listOf<CategoryDto>()
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
        amount: Int,
        difficulty: String,
        type: String?,
        category: Int?
    ): Resource<QuestionDto> {
        return try {
            Success(
                data = api.getQuestion(
                    amount = amount,
                    category = category,
                    difficulty = difficulty,
                    type = type
                )
            )
        } catch (e: Exception){
            e.printStackTrace()
            Error(e.message ?: "An unknown error occurred.")
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
