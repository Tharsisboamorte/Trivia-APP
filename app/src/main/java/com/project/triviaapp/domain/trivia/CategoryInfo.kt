package com.project.triviaapp.domain.trivia

data class CategoryInfo(
    val categoryInfo: Map<Int, List<CategoriesData>>,
    val currentCategories: List<CategoriesData> = listOf()
)
