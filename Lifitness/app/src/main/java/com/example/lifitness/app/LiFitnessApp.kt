package com.example.lifitness.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.lifitness.screens.SignUpScreen

@Composable
fun LiFitnessApp(){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        SignUpScreen()
    }
}