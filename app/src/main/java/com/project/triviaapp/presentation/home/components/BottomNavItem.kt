package com.project.triviaapp.presentation.home.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter


data class BottomNavItem(
    val icon: Painter,
    val label: @Composable () -> Unit
)