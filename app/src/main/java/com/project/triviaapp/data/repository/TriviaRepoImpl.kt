package com.project.triviaapp.data.repository

import com.project.triviaapp.data.datasource.QuestionDto
import com.project.triviaapp.data.datasource.TriviaApi
import com.project.triviaapp.data.mappers.toCategoryInfo
import com.project.triviaapp.domain.repository.TriviaRepo
import com.project.triviaapp.domain.trivia.CategoryInfo
import com.project.triviaapp.domain.util.Resource
import com.project.triviaapp.domain.util.Resource.Error
import com.project.triviaapp.domain.util.Resource.Success
import javax.inject.Inject


class TriviaRepoImpl @Inject constructor(
    private val api: TriviaApi
): TriviaRepo {
    override suspend fun getCategories(): Resource<CategoryInfo> {
        return try {
            Success(
                data = api.getCategories().toCategoryInfo()
            )
        } catch (e: Exception){
            e.printStackTrace()
            Error(e.message ?: "An unknown error occurred.")
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
}
