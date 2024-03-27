@file:Suppress("UNCHECKED_CAST")

package com.project.triviaapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.project.triviaapp.presentation.home.HomePage
import com.project.triviaapp.presentation.question.QuestionPage
import com.project.triviaapp.redux.TriviaState

@Composable
fun TriviaNavHost(
    navController: NavHostController,
    state: TriviaState
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Home.route
    ) {
        composable(
            route = Screens.Home.route
        ){
            HomePage(state = state, navController = navController)
        }
        composable(
            route = Screens.Question.route
        ){
            QuestionPage(state = state)
        }
        composable(
            route = Screens.Rank.route
        ){

        }
    }
}