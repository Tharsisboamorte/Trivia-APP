package com.project.triviaapp.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.triviaapp.R
import kotlinx.coroutines.launch

@Composable
fun CategoryCard(
    title: String,
    image: Painter,
){
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Card(
        modifier = Modifier
            .size(250.dp)
            .clickable {
                scope.launch {
                    snackbarHostState.showSnackbar("")
                }
            },
        shape = CardDefaults.outlinedShape,
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(painter = image, contentDescription = "", modifier = Modifier.size(125.dp))
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = title, style = MaterialTheme.typography.headlineSmall)
        }
        SnackbarHost(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            hostState = snackbarHostState,
        ) {
            SnackBarDefault(
                title = "Escolha a dificuldade",
                firstChoice = "Fácil",
                secondChoice = "Médio",
                thirdChoice = "Difícil"
            ) {

            }
        }
    }
}

@Preview
@Composable
fun CategoryCardPreview (){
    Surface {
        CategoryCard(title = "Geral", image = painterResource(id = R.drawable.quiz))
    }
}