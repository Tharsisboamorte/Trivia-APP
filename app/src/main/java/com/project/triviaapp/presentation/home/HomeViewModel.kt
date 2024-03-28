package com.project.triviaapp.presentation.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.triviaapp.data.datasource.CategoryDto
import com.project.triviaapp.data.repository.TriviaRepoImpl
import com.project.triviaapp.redux.ApplicationState
import com.project.triviaapp.redux.Store
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: TriviaRepoImpl = TriviaRepoImpl.getInstance(),
    val store: Store<ApplicationState>
): ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO){
            val categories = getCategories()
            categoriesState.value = categories
        }
    }

    val categoriesState: MutableState<List<CategoryDto>> = mutableStateOf(emptyList<CategoryDto>())

    private suspend fun getCategories(): List<CategoryDto> {
        return repository.getCategories().categories
    }

    fun onDifficultySelected(difficulty: String) = viewModelScope.launch {
        store.update { currentAppState ->
            return@update currentAppState.copy(
                difficultyMetaData = currentAppState.difficultyMetaData.copy(
                    selectedDifficulty = difficulty
                )
            )

        }
    }
    fun onTypeSelected(type: String) = viewModelScope.launch {
        store.update { currentAppState ->
            return@update currentAppState.copy(
                typeMetaData = currentAppState.typeMetaData.copy(
                    selectedType = type
                )
            )

        }
    }
    fun onCategorySelected(categoryId: Int) = viewModelScope.launch {
        store.update { currentAppState ->
            return@update currentAppState.copy(
                categoryMetaData = currentAppState.categoryMetaData.copy(
                    selectedCategoryId = categoryId
                )
            )

        }
    }
}