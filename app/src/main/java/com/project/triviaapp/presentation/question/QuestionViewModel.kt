package com.project.triviaapp.presentation.question

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.triviaapp.data.datasource.CategoryDto
import com.project.triviaapp.data.datasource.QuestionDto
import com.project.triviaapp.data.repository.TriviaRepoImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuestionViewModel(
    private val repository: TriviaRepoImpl = TriviaRepoImpl.getInstance()
) : ViewModel() {

    init {

    }

    fun requestQuestion(level: String, category: Int, type: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val question = getQuestion(level = level, category = category, type = type)
            question.forEach { _ ->
                questionState.value = question[0]
            }
        }
    }

    val questionState: MutableState<QuestionDto> = mutableStateOf(QuestionDto.empty())
    private suspend fun getQuestion(level: String, category: Int, type: String): List<QuestionDto> {
        return repository.getQuestion(
            difficulty = level,
            category = category,
            type = type
        ).question
    }
}