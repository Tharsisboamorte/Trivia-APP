package com.project.triviaapp.presentation.question

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.triviaapp.data.datasource.QuestionDto
import com.project.triviaapp.data.repository.TriviaRepoImpl
import com.project.triviaapp.presentation.home.HomeViewModel
import com.project.triviaapp.presentation.userschoice.UsersChoiceViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuestionViewModel(
    private val repository: TriviaRepoImpl = TriviaRepoImpl.getInstance()
) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            val question = getQuestion()
            question.forEach{ _ ->
                questionState.value = question[0]
            }
        }
    }

    val questionState: MutableState<QuestionDto> = mutableStateOf(QuestionDto.empty())
    private suspend fun getQuestion(): List<QuestionDto> {
        return repository.getQuestion(
            difficulty = UsersChoiceViewModel().difficultyState.value,
            category = HomeViewModel().categoryStateId.value,
            type = UsersChoiceViewModel().typeState.value
        ).question
    }
}