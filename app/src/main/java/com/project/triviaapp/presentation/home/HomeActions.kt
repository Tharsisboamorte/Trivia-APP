package com.project.triviaapp.presentation.home

class HomeActions(private val viewModel: HomeViewModel) {

    fun onCategorySelected(categoryId: Int) {
        viewModel.onCategorySelected(categoryId = categoryId)
    }

    fun onTypeSelected(type: String) {
        viewModel.onTypeSelected(type = type)
    }

    fun onDifficultySelected(difficulty: String) {
        viewModel.onDifficultySelected(difficulty = difficulty)
    }

}