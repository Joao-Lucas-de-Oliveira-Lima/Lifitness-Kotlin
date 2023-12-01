package com.lifitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.firebase.FirebaseApp
import com.lifitness.app.LiFitnessApp
import com.lifitness.singleton.LoggedInUserSingleton
import com.lifitness.ui.theme.LifitnessTheme


//todo separate the logic from the UI
class MainActivity : ComponentActivity() {
    val loggedInUserSingleton = LoggedInUserSingleton.getInstance();
    override fun onCreate(savedInstanceState: Bundle?) {
        loggedInUserSingleton.myValue = "Ola"
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContent {
            LifitnessTheme {
                LiFitnessApp()
            }
        }
    }
}
