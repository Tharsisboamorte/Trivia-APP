package com.project.triviaapp.data.datasource

import com.squareup.moshi.Json

data class CategoriesResponse(
    @field:Json(name = "trivia_categories")
    val categories: List<CategoryDto>
)
data class CategoryDto(
    @field:Json(name = "id")val id: Int,
    @field:Json(name = "name")val name: String,
)
