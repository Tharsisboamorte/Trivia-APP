package com.project.triviaapp.presentation.userschoice

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.triviaapp.data.repository.TriviaRepoImpl
import com.project.triviaapp.presentation.home.HomeViewModel
import kotlinx.coroutines.launch

class UsersChoiceViewModel(
    private val repository: TriviaRepoImpl = TriviaRepoImpl.getInstance()
) : ViewModel() {

    val difficultyState: MutableState<String> = mutableStateOf("")
    val typeState: MutableState<String> = mutableStateOf("")

    fun onDifficultySelected(difficulty: String) = viewModelScope.launch {
        difficultyState.value = difficulty
    }

    fun onTypeSelected(type: String) = viewModelScope.launch {
        typeState.value = type
    }



}