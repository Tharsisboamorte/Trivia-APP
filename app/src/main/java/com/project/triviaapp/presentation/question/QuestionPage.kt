package com.project.triviaapp.presentation.question

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.project.triviaapp.navigation.Screens
import com.project.triviaapp.presentation.home.HomeViewModel
import com.project.triviaapp.presentation.question.components.CountdownCircularProgressBar
import com.project.triviaapp.presentation.question.components.GameButton
import com.project.triviaapp.ui.theme.LightBlue
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun QuestionPage(
    navController: NavController,
) {
    val viewModel: QuestionViewModel = viewModel()
    val questionState = viewModel.questionState.value
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    val answers = mutableListOf<String>()

    answers.addAll(questionState.incorrectAnswers)
    answers.add(questionState.correctAnswer)

    answers.shuffle()

    Scaffold(
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CountdownCircularProgressBar(coroutineScope)
            Spacer(modifier = Modifier.height(25.dp))
            Card(
                modifier = Modifier
                    .height(250.dp)
                    .width(350.dp),
                colors = CardDefaults.cardColors(
                    containerColor = LightBlue
                )
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = questionState.question,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color.DarkGray,
                        softWrap = true,
                        overflow = TextOverflow.Visible,
                    )
                }
            }
            Spacer(modifier = Modifier.height(25.dp))
            LazyColumn(contentPadding = PaddingValues(start = 15.dp, end = 15.dp)) {
                items(answers) { index ->
                    GameButton(
                        text = index,
                        onClick = {
                            if (index == questionState.correctAnswer) {
                                coroutineScope.launch {
                                    snackbarHostState.showSnackbar("A resposta está correta!")
                                }
                                coroutineScope.cancel()
                                navController.navigate(Screens.Home.route)
                            }
                        },
                    )
                }
            }

        }
    }
}
