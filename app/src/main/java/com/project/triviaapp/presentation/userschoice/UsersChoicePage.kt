package com.project.triviaapp.presentation.userschoice

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.project.triviaapp.navigation.Screens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UsersChoicePage(
    navController: NavController
) {
    val choicesModel: UsersChoiceViewModel = viewModel()
    val radioDifficultyOptions = listOf("Fácil", "Médio", "Difícil")
    val radioTypeOptions = listOf("Multipla escolha", "Verdadeiro ou Falso", "Ambos")
    var selectedDifficultyOption by remember { mutableStateOf(radioDifficultyOptions[0]) }
    var selectedTypeOption by remember { mutableStateOf(radioTypeOptions[0]) }


    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Dificuldade",
                    Modifier.padding(start = 100.dp, end = 50.dp),
                    style = MaterialTheme.typography.headlineMedium,
                )
                radioDifficultyOptions.forEach { difficulty ->
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (difficulty == selectedDifficultyOption),
                            onClick = {
                                selectedDifficultyOption = difficulty
                                when (difficulty) {
                                    "Fácil" -> {
                                        choicesModel.onDifficultySelected("easy")
                                    }

                                    "Médio" -> {
                                        choicesModel.onDifficultySelected("medium")
                                    }

                                    "Difícil" -> {
                                        choicesModel.onDifficultySelected("hard")
                                    }
                                }
                            }
                        )
                        Text(
                            text = difficulty,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(25.dp))
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Modo",
                    Modifier.padding(start = 150.dp, end = 50.dp),
                    style = MaterialTheme.typography.headlineMedium
                )
                radioTypeOptions.forEach { types ->
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (types == selectedTypeOption),
                            onClick = {
                                selectedTypeOption = types
                                when (types) {
                                    "Multipla escolha" -> {
                                        choicesModel.onTypeSelected("multiple")
                                    }

                                    "Verdadeiro ou Falso" -> {
                                        choicesModel.onTypeSelected("boolean")
                                    }

                                    "Ambos" -> {
                                        choicesModel.onTypeSelected("")
                                    }
                                }
                            }
                        )
                        Text(
                            text = types,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = {
                    navController.navigate(Screens.Question.route)
                }) {
                    Text(text = "Gerar pergunta")
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewChoice() {
    Surface {
        UsersChoicePage(rememberNavController())
    }
}