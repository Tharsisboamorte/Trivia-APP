package com.project.triviaapp.presentation.home.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.project.triviaapp.navigation.Screens
import com.project.triviaapp.ui.theme.LightBlue

@Composable
fun BottomNavBar(
    navController: NavController
) {
    var selectedTab by remember { mutableIntStateOf(0) }

    val items = listOf(
        Icons.Outlined.Home to "Home",
        Icons.Outlined.List to "Rank"
    )

    NavigationBar(
        modifier = Modifier.height(30.dp),
        containerColor = Color.White
    ) {
        items.forEachIndexed { index, (icon) ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.White,
                ),
                selected = selectedTab == index,
                onClick = {
                    when (index) {
                        0 -> navController.navigate(Screens.Home.route)
                        1 -> navController.navigate(Screens.Rank.route)
                    }
                    selectedTab = index
                },
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = LightBlue,
                    )

                },
                alwaysShowLabel = false,
            )
        }
    }
//    BottomAppBar(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(25.dp),
//        containerColor = Color.White,
//        contentColor = Color.White,
//    ) {
//        items.forEachIndexed { index, (icon) ->
//            val isSelected = index == selectedTab
//            NavigationBarItem(
//                selected = isSelected,
//                onClick = {
//                    when (index) {
//                        0 -> {
//                            navController.navigate(Screens.Home.route)
//                            selectedTab = 0
//                        }
//                        1 -> {
//                            navController.navigate(Screens.Rank.route)
//                            selectedTab = 1
//                        }
//                    }
//                },
//                colors = NavigationBarItemDefaults.colors(
//                    indicatorColor = Color.White
//                ),
//                icon = {
//                    Icon(
//                        imageVector = icon,
//                        contentDescription = null,
//                        tint = LightBlue,
//                    )
//                },
//                alwaysShowLabel = false,
//            )
//        }
//
//    }
}

@Preview
@Composable
fun PreviewBottomNavBar() {
    Surface(modifier = Modifier.fillMaxSize()) {
        BottomNavBar(rememberNavController())
    }
}