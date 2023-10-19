package com.lifitness.common.layouts

import android.graphics.Path
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.rememberNavController
// import com.lifitness.common.composable.Navbar

//enum class Screens(val icon: ImageVector, val destination: Path.Direction) {
//    HOME(Icons.Filled.Home, TrainDestination),
//    GAINS(Icons.Filled.BarChart, GainsDestination),
//    TRAIN(Icons.Filled.FitnessCenter, AskDestination),
//    MORE(Icons.Filled.Person, ProfileDestination),
//    DIET(Icons.Filled.Restaurant, DietDestination)
//}
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AppScaffold(
//    currentScreen: Screens,
//    navigator: DestinationNavigator,
//    bottomAppBar: @Composable (Screens) -> Unit = {
//        Navbar(currentScreen = currentScreen, navigator = navigator)
//    },
//    content: @Composable () -> Unit
//){
//    val navController = rememberNavController()
//    Scaffold(
//        bottomBar = {
//            bottomAppBar(currentScreen)
//        }
//    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(it)
//        )
//    }
//}