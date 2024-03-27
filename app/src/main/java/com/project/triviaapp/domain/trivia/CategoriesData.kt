package com.project.triviaapp.domain.trivia

data class CategoriesData(
    val id: Int,
    val name: String,
){
    companion object {

        fun empty() = CategoriesData(
            id = 0,
            name = ""
        )

    }
}