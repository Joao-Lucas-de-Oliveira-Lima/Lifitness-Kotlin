package com.lifitness.screens.exercises

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
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

@Composable
fun ExercisesScreen(navController: NavHostController) {
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
                        HealthInstructorCard("Clécia")
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
                ExerciseCard("TREINO DE ABDÔMEN", "20 MIN")
                ExerciseCard("TREINO DE PEITO", "9 MIN")
                ExerciseCard("TREINO DE BRAÇO", "17 MIN")
                ExerciseCard("TREINO DE PERNA", "26 MIN")
            }

            item {
                IntermediateTitle()
                ExerciseCard("TREINO DE ABDÔMEN", "26 MIN")
                ExerciseCard("TREINO DE PEITO", "15 MIN")
                ExerciseCard("TREINO DE BRAÇO", "26 MIN")
                ExerciseCard("TREINO DE PERNA", "41 MIN")
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
    ExercisesScreen(navController)
}