package com.project.triviaapp.presentation.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.triviaapp.data.datasource.CategoryDto
import com.project.triviaapp.data.repository.TriviaRepoImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeVieModel(
    private val repository: TriviaRepoImpl = TriviaRepoImpl.getInstance()
): ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO){
            val categories = getCategories()
            categoriesState.value = categories
        }
    }

    val categoriesState: MutableState<List<CategoryDto>> = mutableStateOf(listOf())
    private suspend fun getCategories(): List<CategoryDto> {
        return repository.getCategories().categories
    }
}