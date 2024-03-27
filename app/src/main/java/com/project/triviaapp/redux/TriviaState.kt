package com.project.triviaapp.redux

import com.project.triviaapp.domain.trivia.CategoryInfo
import com.project.triviaapp.domain.trivia.QuestionData
import com.project.triviaapp.domain.trivia.UserChoices

data class TriviaState (
    val categories: CategoryInfo? = null,
    val question: QuestionData = QuestionData.empty(),
    val queries: UserChoices = UserChoices(),
)