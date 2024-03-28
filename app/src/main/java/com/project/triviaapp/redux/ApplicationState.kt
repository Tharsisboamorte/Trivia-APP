package com.project.triviaapp.redux

import com.project.triviaapp.data.datasource.CategoryDto

data class ApplicationState(
    val categories: List<CategoryDto> = emptyList(),
)
