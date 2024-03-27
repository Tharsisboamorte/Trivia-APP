package com.project.triviaapp.data.mappers

import com.project.triviaapp.data.datasource.CategoriesDataDto
import com.project.triviaapp.data.datasource.TriviaDto
import com.project.triviaapp.domain.trivia.CategoriesData
import com.project.triviaapp.domain.trivia.CategoryInfo


private data class IndexedCategoriesData(
    val index: Int,
    val data: CategoriesData
)
private data class IndexedQuestionData(
    val id: Int,
    val data: CategoriesData
)
fun CategoriesDataDto.toCategoriesDataMap(): Map<Int, List<CategoriesData>> {

    return categories.mapIndexed { index, categories ->
        IndexedCategoriesData(
            index = index,
            data = CategoriesData(
                id = categories.id,
                name = categories.name
            )
        )
    }.groupBy {
        it.index
    }.mapValues {
        it.value.map { it.data }
    }

}

fun TriviaDto.toCategoryInfo(): CategoryInfo {
    val  categoryDataMap = categories.toCategoriesDataMap()
    return CategoryInfo(
        categoryInfo = categoryDataMap,
    )
}