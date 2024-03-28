package com.project.triviaapp.presentation.question.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun GameButton(
    text: String,
    textColor: Color = Color.White,
    onClick: (String) -> Unit,
) {

    Button(
        onClick = {
            onClick(text)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .wrapContentHeight()
            .defaultMinSize(minHeight = 54.dp),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, color = Color.Gray),
        colors = ButtonDefaults.buttonColors(
           containerColor = Color.White
        ),
    ) {
        Text(
            textAlign = TextAlign.Center,
            text = text, style = MaterialTheme.typography.bodyLarge, color = Color.Black
        )
    }
}

@Preview
@Composable
fun PreviewGameButton() {
    Surface {
        GameButton(
            text = "Verdadeiro",
            onClick = {},
        )
    }
}