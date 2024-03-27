package com.project.triviaapp.data.datasource

import com.squareup.moshi.Json

data class CategoriesDataDto (
    @field:Json(name = "trivia_categories")
    val categories: List<CategoryDto>,
)