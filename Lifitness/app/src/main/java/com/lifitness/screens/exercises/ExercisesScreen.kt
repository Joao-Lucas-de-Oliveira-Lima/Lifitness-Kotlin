package com.lifitness.screens.exercises

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lifitness.common.composable.BegginerTitle
import com.lifitness.common.composable.ExerciseCard
import com.lifitness.common.composable.HealthInstructorCard
import com.lifitness.common.composable.HireInstructorTitle
import com.lifitness.common.composable.IntermediateTitle
import com.lifitness.common.composable.TrainsTitle
import com.lifitness.common.ext.spacer
import com.lifitness.ui.theme.BackgroundColor

@Composable
fun ExercisesScreen() {
    Box (
        modifier = Modifier
            .background(BackgroundColor)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ){
        Column {
            Row {
                TrainsTitle()
            }
            Spacer(modifier = Modifier.spacer())
            HireInstructorTitle()
            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
            ) {
                HealthInstructorCard(exerciseName = "Paula")
                HealthInstructorCard(exerciseName = "Carlos")
                HealthInstructorCard(exerciseName = "Carlos")
                HealthInstructorCard(exerciseName = "Carlos")
                HealthInstructorCard(exerciseName = "Carlos")
            }
            Spacer(modifier = Modifier.spacer())
            Column {
                BegginerTitle()
                ExerciseCard("TREINO DE ABDÔMEN", "20 MIN")
                ExerciseCard("TREINO DE PEITO", "9 MIN")
                ExerciseCard("TREINO DE BRAÇO", "17 MIN")
                ExerciseCard("TREINO DE PERNA", "26 MIN")
            }
            Column {
                IntermediateTitle()
                ExerciseCard("TREINO DE ABDÔMEN", "26 MIN")
                ExerciseCard("TREINO DE PEITO", "15 MIN")
                ExerciseCard("TREINO DE BRAÇO", "26 MIN")
                ExerciseCard("TREINO DE PERNA", "41 MIN")
            }
        }
    }
}

@Preview
@Composable
fun defaultPreviewExercises() {
    ExercisesScreen()
}