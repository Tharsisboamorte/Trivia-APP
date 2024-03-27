package com.project.triviaapp.navigation

sealed class Screens(val route: String) {

    object Home: Screens(route = "home_screen")

    object Rank: Screens(route = "ranking_screen")

    object Question: Screens(route = "ranking_screen")
}