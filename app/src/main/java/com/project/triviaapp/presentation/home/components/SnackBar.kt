package com.project.triviaapp.presentation.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SnackBarDefault(
    title: String,
    firstChoice: String,
    secondChoice: String,
    thirdChoice: String? = null,
    onAction: () -> Unit,
) {
    Snackbar(
        modifier = Modifier
            .wrapContentSize(),
        shape = SnackbarDefaults.shape,
        containerColor = Color.White,
    ) {
        Column(
            modifier = Modifier.wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                modifier = Modifier.wrapContentSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                TextButton(
                    modifier = Modifier.padding(start = 25.dp),
                    border = BorderStroke(width = 2.dp, color = Color.Black),
                    onClick = { /*TODO*/ },
                ) {
                    Text(
                        text = firstChoice,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Black,
                    )
                }
                Spacer(modifier = Modifier.width(50.dp))
                TextButton(
                    border = BorderStroke(width = 2.dp, color = Color.Black),
                    onClick = { /*TODO*/ },
                ) {
                    Text(
                        text = secondChoice,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Black,
                    )
                }
                Spacer(modifier = Modifier.width(50.dp))
                if(thirdChoice != null){
                    TextButton(
                        border = BorderStroke(width = 2.dp, color = Color.Black),
                        onClick = { /*TODO*/ },
                    ) {
                        Text(
                            text = thirdChoice,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Black,
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewSnackBar() {
    Surface {
       Column {
           SnackBarDefault(
               title = "Escolha a dificuldade",
               firstChoice = "Fácil",
               secondChoice = "Médio",
               thirdChoice = "Difícil",
               onAction = {}
           )
           Spacer(modifier = Modifier.height(25.dp))
           SnackBarDefault(
               title = "Escolha a dificuldade",
               firstChoice = "Fácil",
               secondChoice = "Médio",
               onAction = {}
           )
       }
    }
}