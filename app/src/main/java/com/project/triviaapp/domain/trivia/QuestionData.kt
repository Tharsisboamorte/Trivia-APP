package com.project.triviaapp.domain.trivia

data class QuestionData(
    val question: String,
    val correctAnswer: String,
    val incorrectAnswers: List<String>
){
    companion object {
        fun empty() = QuestionData(
            question = "",
            correctAnswer = "",
            incorrectAnswers = listOf()
        )
    }
}
