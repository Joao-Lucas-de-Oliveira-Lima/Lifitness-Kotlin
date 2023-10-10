package com.lifitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.lifitness.app.LiFitnessApp
import com.lifitness.ui.theme.LifitnessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LifitnessTheme {
                LiFitnessApp()
            }
        }
    }
}
