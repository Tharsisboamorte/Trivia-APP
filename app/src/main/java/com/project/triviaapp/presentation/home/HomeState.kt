package com.project.triviaapp.presentation.home

sealed class HomeState {
    object Loading: HomeState()
    data class Error(val errorMessage: String): HomeState()
    data class Success(
        val pointsEarned: Int,
        val hasLost: Boolean,
    )
}