package com.project.triviaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.project.triviaapp.navigation.TriviaNavHost
import com.project.triviaapp.redux.ApplicationState
import com.project.triviaapp.ui.theme.TriviaAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    private var appState: ApplicationState by mutableStateOf(ApplicationState())
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            TriviaAppTheme {
                navController = rememberNavController()
                TriviaNavHost(navController = navController)
            }
        }
    }
}