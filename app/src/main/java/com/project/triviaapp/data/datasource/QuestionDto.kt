package com.project.triviaapp.data.datasource

data class QuestionDto(
    val question: String,
    val correctAnswer: String,
    val incorrectAnswers: List<String>,
)
