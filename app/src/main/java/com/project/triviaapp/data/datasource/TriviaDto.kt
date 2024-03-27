package com.project.triviaapp.data.datasource

import com.squareup.moshi.Json

data class TriviaDto(
    @field:Json(name = "trivia_categories")
    val categories: CategoriesDataDto
)