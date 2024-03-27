package com.project.triviaapp.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.project.triviaapp.R
import com.project.triviaapp.presentation.home.components.BottomNavBar
import com.project.triviaapp.presentation.home.components.CategoryCard
import com.project.triviaapp.redux.TriviaState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomePage(
    state: TriviaState,
    navController: NavController,
) {
    state.categories?.currentCategories.let { data ->
        Scaffold(
            bottomBar = {
                BottomNavBar()
            },
        ) {
            LazyColumn() {
                item {
                    Row(
                        horizontalArrangement = Arrangement.Absolute.Center,
                        verticalAlignment = Alignment.Top,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Categorias", style = MaterialTheme.typography.headlineMedium)
                    }
                }
                items(data!!.size) { category ->
                    CategoryCard(
                        title = data[category].name,
                        image = painterResource(id = R.drawable.quiz)
                    )
                }
            }
        }
    }
}