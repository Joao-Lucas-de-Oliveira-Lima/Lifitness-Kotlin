package com.lifitness.screens.trains

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import com.lifitness.common.composable.BegginerTitle
import com.lifitness.common.composable.ExerciseCard
import com.lifitness.common.composable.HealthInstructorCard
import com.lifitness.common.composable.HireInstructorTitle
import com.lifitness.common.composable.IntermediateTitle
import com.lifitness.common.composable.PersonalTrainCard
import com.lifitness.common.composable.PersonalTrainerTitle
import com.lifitness.common.composable.TrainsTitle
import com.lifitness.common.ext.endOfScreenSpacer
import com.lifitness.common.ext.spacer
import com.lifitness.ui.theme.BackgroundColor
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Composable
fun TrainsScreen(navController: NavHostController) {
    val basicExercisesViewModel: TrainsViewModel = viewModel(factory = TrainsViewModelFactory("train/default/basic"), key = "basicExercise")
    val basicExercises = basicExercisesViewModel.trains.observeAsState()
    val adeptExercisesViewModel: TrainsViewModel = viewModel(factory = TrainsViewModelFactory("train/default/adept"), key = "adeptExercise")
    val adeptExercises = adeptExercisesViewModel.trains.observeAsState()

    Box(
        modifier = Modifier
            .background(BackgroundColor)
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                TrainsTitle()
            }

            item {
                HireInstructorTitle()
                LazyRow {
                    items(4) {
                        HealthInstructorCard("Clécia", {})
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.spacer())
                PersonalTrainerTitle()
                PersonalTrainCard("pedro", "carlo")
            }

            item {
                Spacer(modifier = Modifier.spacer())
                BegginerTitle()
            }
            basicExercises.value?.chunked(4) { chunk ->
                items(chunk) { exercise ->
                    ExerciseCard(exercise.trainName, exercise.duration) {
                        navController.navigate(LifitnessScreen.Train.name)
                    }
                }
            }

            item {
                IntermediateTitle()
            }

            adeptExercises.value?.chunked(4) { chunk ->
                items(chunk) { exercise ->
                    ExerciseCard(exercise.trainName, exercise.duration) {
                        navController.navigate("${LifitnessScreen.ExerciseViewList.name}/${Json.encodeToString(exercise)}")
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.endOfScreenSpacer())
            }

            item {
                Spacer(modifier = Modifier.endOfScreenSpacer())
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreviewExercises() {
    val navController = rememberNavController()
    TrainsScreen(navController)
}