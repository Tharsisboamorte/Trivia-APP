package com.project.triviaapp.presentation.question.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.triviaapp.ui.theme.LightBlue
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun CountdownCircularProgressBar() {
    var countdown by remember { mutableIntStateOf(10) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            for (i in 10 downTo 0) {
                countdown = i
                delay(1000) // Delay for 1 second
            }
        }
    }

    Box(contentAlignment = Alignment.Center, modifier = Modifier.wrapContentSize()) {
        CircularProgressIndicator(
            progress = countdown / 10f,
            modifier = Modifier.size(100.dp),
            color = LightBlue,
            strokeWidth = 8.dp,
            trackColor = Color.Gray
        )
        Text(
            text = "$countdown",
            style = TextStyle(
                fontSize = 34.sp,
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold,
            ),
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview
@Composable
fun PreviewCountDown() {
    Surface {
        CountdownCircularProgressBar()
    }
}