package com.project.triviaapp.redux

import com.project.triviaapp.data.datasource.CategoryDto

data class ApplicationState (
    val categories: List<CategoryDto> = emptyList(),
    val categoryMetaData: CategoryMetadata = CategoryMetadata(),
    val typeMetaData: TypeMetaData = TypeMetaData(),
    val difficultyMetaData: DifficultyMetaData = DifficultyMetaData()
){


    data class CategoryMetadata(
        val selectedCategoryId: Int = 0
    )
    data class TypeMetaData(
        val selectedType: String = ""
    )
    data class DifficultyMetaData(
        val selectedDifficulty: String = ""
    )

}