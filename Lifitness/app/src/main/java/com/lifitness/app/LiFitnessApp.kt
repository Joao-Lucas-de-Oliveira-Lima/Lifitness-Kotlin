package com.lifitness.app

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Egg
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.BarChart
import androidx.compose.material.icons.outlined.Egg
import androidx.compose.material.icons.outlined.FitnessCenter
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lifitness.screens.diets.DietsScreen
import com.lifitness.screens.diets.food.FoodScreen
import com.lifitness.screens.editProfile.EditProfileScreen
import com.lifitness.screens.exercises.ExercisesScreen
import com.lifitness.screens.exercises.exercise.ExerciseDescriptionScreen
import com.lifitness.screens.home.HomeScreen
import com.lifitness.screens.login.LoginScreen
import com.lifitness.screens.profile.ProfileScreen
import com.lifitness.screens.progress.ProgressScreen
import com.lifitness.screens.register.MainRegistrationScreen
import com.lifitness.screens.register.goalRegistration.GoalRegistrationScreen
import com.lifitness.screens.register.impedimentsRegistration.ImpedimentsRegistrationScreen
import com.lifitness.screens.register.personalDataRegistration.PersonalDataRegistrationScreen
import com.lifitness.ui.theme.CardBackground
import com.lifitness.ui.theme.RedChart

enum class LifitnessScreen {
    Login,
    Register,
    PersonalData,
    GoalRegistration,
    ImpedimentsRegistration,
    Home,
    Main_Exercises,
    Settings,
    Train,
    Main_Diets,
    Food_Screen,
    Profile,
    Charts
}
data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LiFitnessApp() {
    var isLoginScreenDisplayed by remember { mutableStateOf(false) }
    val navController = rememberNavController();

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val items = listOf(
            BottomNavigationItem(
                title = "Home",
                selectedIcon = Icons.Filled.Home,
                unselectedIcon = Icons.Outlined.Home,
                hasNews = false,
            ),
            BottomNavigationItem(
                title = "Diet",
                selectedIcon = Icons.Filled.Egg,
                unselectedIcon = Icons.Outlined.Egg,
                hasNews = false,
            ),
            BottomNavigationItem(
                title = "Train",
                selectedIcon = Icons.Filled.FitnessCenter,
                unselectedIcon = Icons.Outlined.FitnessCenter,
                hasNews = false,
            ),
            BottomNavigationItem(
                title = "Charts",
                selectedIcon = Icons.Filled.BarChart,
                unselectedIcon = Icons.Outlined.BarChart,
                hasNews = false,
            ),
            BottomNavigationItem(
                title = "Profile",
                selectedIcon = Icons.Filled.Person,
                unselectedIcon = Icons.Outlined.Person,
                hasNews = false,
            ),
        )
        var selectedItemIndex by rememberSaveable {
            mutableStateOf(0)
        }
        Scaffold(
            bottomBar = {
                if(!isLoginScreenDisplayed) {
                    NavigationBar(
                        containerColor = CardBackground,
                        contentColor = RedChart,
                    ) {
                        items.forEachIndexed { index, item ->
                            BottomNavigationItem(
                                selected = selectedItemIndex == index,
                                onClick = {
                                    selectedItemIndex = index
                                    when (index) {
                                        0 -> navController.navigate(LifitnessScreen.Home.name)
                                        1 -> navController.navigate(LifitnessScreen.Main_Diets.name)
                                        2 -> navController.navigate(LifitnessScreen.Main_Exercises.name)
                                        3 -> navController.navigate(LifitnessScreen.Charts.name)
                                        4 -> navController.navigate(LifitnessScreen.Profile.name)
                                    }
                                },
                                label = {
                                    Text(text = item.title, color = Color.White)
                                },
                                icon = {
                                    BadgedBox(
                                        badge = {
                                            if (item.hasNews) {
                                                Badge()
                                            }
                                        }
                                    ) {
                                        Icon(
                                            imageVector = if (index == selectedItemIndex) {
                                                item.selectedIcon
                                            } else item.unselectedIcon,
                                            contentDescription = item.title,
                                            tint = RedChart,
                                        )
                                    }
                                })
                        }
                    }
                }
            },
        ) {
            NavHost(navController, startDestination = LifitnessScreen.Login.name) {
                composable(LifitnessScreen.Login.name) {
                    LoginScreen(navController)
                    isLoginScreenDisplayed = true
                }
                composable(LifitnessScreen.Register.name) {
                    MainRegistrationScreen(navController)
                    isLoginScreenDisplayed = true
                }
                composable(LifitnessScreen.PersonalData.name) {
                    PersonalDataRegistrationScreen(navController)
                    isLoginScreenDisplayed = true
                }
                composable(LifitnessScreen.GoalRegistration.name) {
                    GoalRegistrationScreen(navController)
                    isLoginScreenDisplayed = true
                }
                composable(LifitnessScreen.ImpedimentsRegistration.name) {
                    ImpedimentsRegistrationScreen(navController)
                    isLoginScreenDisplayed = true
                }
                composable(LifitnessScreen.Home.name) {
                    HomeScreen(navController)
                    isLoginScreenDisplayed = false
                }
                composable(LifitnessScreen.Main_Exercises.name) {
                    ExercisesScreen(navController)
                }
                composable(LifitnessScreen.Train.name) {
                    ExerciseDescriptionScreen(navController)
                }
                composable(LifitnessScreen.Main_Diets.name) {
                    DietsScreen(navController)
                }
                composable(LifitnessScreen.Food_Screen.name) {
                    FoodScreen(navController)
                }
                composable(LifitnessScreen.Profile.name) {
                    ProfileScreen(modifier = Modifier, navController)
                }
                composable(LifitnessScreen.Charts.name) {
                    ProgressScreen(navController)
                }
                composable(LifitnessScreen.Settings.name) {
                    EditProfileScreen(navController)
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewLiFitnessApp() {
    LiFitnessApp()
}
