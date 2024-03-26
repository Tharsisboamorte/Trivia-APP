package com.project.triviaapp.presentation.question

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.triviaapp.presentation.question.components.CountdownCircularProgressBar
import com.project.triviaapp.ui.theme.LightBlue

@Composable
fun QuestionPage(

) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CountdownCircularProgressBar()
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
                    text = "Lore ipsum acascas",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray
                )
            }
        }
        Spacer(modifier = Modifier.height(25.dp))
        TextButton(
            modifier = Modifier
                .height(50.dp)
                .width(350.dp),
            onClick = { /*TODO*/ },
            shape = ButtonDefaults.outlinedShape,
            border = BorderStroke(2.dp, color = Color.Gray),
        ) {
            Text(
                text = "Verdadeiro",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black
            )
        }
    }
}

@Preview
@Composable
fun PagePreview() {
    Surface {
        QuestionPage(

        )
    }
}