package com.project.triviaapp.data.datasource

data class RequestDto (
    val type: String,
    val level: String,
    val category: Int,
){
    companion object{
        fun empty() = RequestDto(
            type = "",
            level = "",
            category = 0
        )
    }
}