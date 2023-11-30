package com.lifitness.screens.home.client

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lifitness.app.LifitnessScreen
import com.lifitness.common.composable.DietRecommendationCard
import com.lifitness.common.composable.DietsRecomendationTitle
import com.lifitness.common.composable.ExerciseCard
import com.lifitness.common.composable.HomeTitle
import com.lifitness.common.ext.endOfScreenSpacer
import com.lifitness.common.ext.spacer
import com.lifitness.screens.diets.DietsViewModel
import com.lifitness.screens.trains.TrainsViewModel
import com.lifitness.screens.trains.TrainsViewModelFactory
import com.lifitness.ui.theme.BackgroundColor
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Composable
fun HomeScreen(navController: NavHostController, dietViewModel: DietsViewModel){
    val adeptExercisesViewModel: TrainsViewModel = viewModel(factory = TrainsViewModelFactory("train/default/adept"), key = "adeptExercise")
    val adeptExercises = adeptExercisesViewModel.trains.observeAsState()
    val dietValues = dietViewModel.diets.observeAsState()

    LazyColumn(
        userScrollEnabled = true,
                modifier = Modifier
                    .background(BackgroundColor)
                    .fillMaxHeight()) {
        item {
            HomeTitle()
            Spacer(modifier = Modifier.spacer())
        }


        if (adeptExercises.value?.isEmpty() != false) {
            items(4) {
                ExerciseCard(exerciseName = "", exerciseDuration = "", isLoading = true) {}
            }
        } else {
            items(adeptExercises.value!!) {exercise ->
                ExerciseCard(exercise.trainName, exercise.duration, false) {
                    navController.navigate("${LifitnessScreen.ExerciseViewList.name}/${exercise.trainId}")
                }
            }
        }

        item {
            Spacer(modifier = Modifier.spacer())
            DietsRecomendationTitle()
            LazyRow {
                if (dietValues.value?.isEmpty() != false) {
                    items(8) {
                        DietRecommendationCard("", "", false) {  }
                    }
                } else {
                    items(dietValues.value!!) { diet ->
                        DietRecommendationCard(diet.dietName, diet.dietNutricionalTable[0], true) {
                            navController.navigate("${LifitnessScreen.Food_Screen.name}/${Json.encodeToString(diet)}")
                        }
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.endOfScreenSpacer())
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen(){
    val navController = rememberNavController()
    val dietViewModel: DietsViewModel = viewModel()
    HomeScreen(navController, dietViewModel)
}