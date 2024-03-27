package com.project.triviaapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.triviaapp.data.repository.TriviaRepoImpl
import com.project.triviaapp.domain.util.Resource
import com.project.triviaapp.redux.TriviaState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val triviaRepo: TriviaRepoImpl
): ViewModel() {



    var state by mutableStateOf(TriviaState())
    fun loadCategories() = viewModelScope.launch {
        try {
            state = when(val response = triviaRepo.getCategories()){
                is Resource.Success -> {
                    state.copy(
                        categories = response.data
                    )
                }

                is Resource.Error -> {
                    state.copy(
                        categories = null
                    )
                }

            }

        } catch (e: Exception){
            e.printStackTrace()
        }
    }

}