package com.project.triviaapp.presentation.ranking

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.project.triviaapp.presentation.home.components.BottomNavBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RankPage(
    navController: NavController
) {
    Scaffold(
        bottomBar = {
            BottomNavBar(navController = navController)
        }
    ) {
        Column {
            Text(text = " Rank Page")
        }
    }
}