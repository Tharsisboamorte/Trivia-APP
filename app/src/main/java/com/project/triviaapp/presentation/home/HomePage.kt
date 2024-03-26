package com.project.triviaapp.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomePage(){
    Scaffold {
//        LazyColumn(content = ""){
//
//        }
    }
}

@Preview
@Composable
fun PreviewHomePage(){
    Surface {
        HomePage()
    }
}