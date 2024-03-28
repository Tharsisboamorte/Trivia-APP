package com.project.triviaapp.presentation.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetModalDifficulty(
    bottomSheetState: BottomSheetScaffoldState,
) {
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Escolha a dificuldade",
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
                onClick = {
                    scope.launch {
                        bottomSheetState.bottomSheetState.expand()
                    }
                },
            ) {
                Text(
                    text = "Fácil",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black,
                )
            }
            Spacer(modifier = Modifier.width(50.dp))
            TextButton(
                border = BorderStroke(width = 2.dp, color = Color.Black),
                onClick = {
                    scope.launch {
                        bottomSheetState.bottomSheetState.expand()
                    }
                },
            ) {
                Text(
                    text = "Médio",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black,
                )
            }
            Spacer(modifier = Modifier.width(50.dp))
            TextButton(
                border = BorderStroke(width = 2.dp, color = Color.Black),
                onClick = {
                    scope.launch {
                        bottomSheetState.bottomSheetState.expand()
                    }
                },
            ) {
                Text(
                    text = "Difícil",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black,
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewBottomSheetDefault() {
    Surface {
        Column {

        }
    }
}