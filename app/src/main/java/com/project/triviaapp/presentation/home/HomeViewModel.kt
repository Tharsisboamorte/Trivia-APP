package com.project.triviaapp.presentation.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.triviaapp.data.datasource.CategoryDto
import com.project.triviaapp.data.repository.TriviaRepoImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: TriviaRepoImpl = TriviaRepoImpl.getInstance()
) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            val categories = getCategories()
            categoriesState.value = categories
        }
    }

    val categoriesState: MutableState<List<CategoryDto>> = mutableStateOf(listOf())
    val categoryStateId: MutableState<Int> = mutableIntStateOf(0)
    private suspend fun getCategories(): List<CategoryDto> {
        return repository.getCategories().categories
    }

    private fun getCategoryId(categoryId: Int): Int {
        return repository.getCategoryId(categoryId)!!.id
    }

    fun onCategorySelected(categoryId: Int) {
        viewModelScope.launch {
            val idCategory = getCategoryId(categoryId = categoryId)
            categoryStateId.value = idCategory
        }
    }
}