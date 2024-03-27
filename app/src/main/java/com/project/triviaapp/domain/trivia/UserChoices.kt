package com.project.triviaapp.domain.trivia

data class UserChoices(
    val amount: Int = 1,
    val difficulty: String = "easy",
    val type: String? = "multiple",
    val category: Int? = 22,
)
