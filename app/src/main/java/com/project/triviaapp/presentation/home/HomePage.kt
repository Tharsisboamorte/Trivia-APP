package com.project.triviaapp.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.project.triviaapp.presentation.home.components.BottomNavBar
import com.project.triviaapp.presentation.home.components.BottomSheetModalDifficulty
import com.project.triviaapp.presentation.home.components.CategoryCard
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomePage() {
    val viewModel: HomeVieModel = viewModel()
    val categories = viewModel.categoriesState.value
    val scope = rememberCoroutineScope()
    val modalSheetState = rememberStandardBottomSheetState(
        initialValue = SheetValue.Hidden,
        skipHiddenState = false,
    )
    val scaffoldSheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = modalSheetState
    )

    BottomSheetScaffold(
        sheetContent = { BottomSheetModalDifficulty() },
        sheetPeekHeight = 50.dp,
        scaffoldState = scaffoldSheetState,
        sheetSwipeEnabled = true
    ) {
        Scaffold(
            modifier = Modifier.pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        scope.launch {
                            if (scaffoldSheetState.bottomSheetState.hasExpandedState) {
                                scaffoldSheetState.bottomSheetState.hide()
                            }
                        }
                    }
                )
            },
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
                            Text(
                                text = "Categorias",
                                style = MaterialTheme.typography.headlineMedium
                            )
                        }
                    }
                    items(categories) { categories ->
                        Spacer(modifier = Modifier.height(15.dp))
                        CategoryCard(
                            title = categories.name,
                            bottomSheetState = scaffoldSheetState
                        )
                    }
                }
                Spacer(modifier = Modifier.height(25.dp))
            } else {
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator(
                        color = Color.Gray
                    )
                    Text(text = "Loading...", style = MaterialTheme.typography.headlineLarge)
                }
            }
        }
    }
}