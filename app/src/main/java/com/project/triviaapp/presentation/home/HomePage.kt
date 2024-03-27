package com.project.triviaapp.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.project.triviaapp.R
import com.project.triviaapp.presentation.home.components.BottomNavBar
import com.project.triviaapp.presentation.home.components.CategoryCard

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomePage() {
    val viewModel: HomeVieModel = viewModel()
    val categories = viewModel.categoriesState.value
    Scaffold(
        bottomBar = {
            BottomNavBar()
        },
    ) {
        if (categories.isNotEmpty()) {
            LazyColumn(contentPadding = PaddingValues(16.dp)) {
                item {
                    Row(
                        horizontalArrangement = Arrangement.Absolute.Center,
                        verticalAlignment = Alignment.Top,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Categorias", style = MaterialTheme.typography.headlineMedium)
                    }
                }
                items(categories) { categories ->
                    CategoryCard(
                        title = categories.name,
                        image = painterResource(id = R.drawable.quiz)
                    )
                }
            }
        } else {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Error not found", style = MaterialTheme.typography.headlineLarge)
            }
        }
    }
}