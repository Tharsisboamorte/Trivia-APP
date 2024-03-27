package com.project.triviaapp.data.datasource

import com.squareup.moshi.Json


data class QuestionResponse(
    @field:Json(name = "results")
    val question: List<QuestionDto>
)
data class QuestionDto(
    @field:Json(name = "question")
    val question: String,
    @field:Json(name = "correct_answer")
    val correctAnswer: String,
    @field:Json(name = "incorrect_answers")
    val incorrectAnswers: List<String>,
){
    companion object{
        fun empty() = QuestionDto(
            question = "",
            correctAnswer = "",
            incorrectAnswers = listOf()
        )
    }
}
