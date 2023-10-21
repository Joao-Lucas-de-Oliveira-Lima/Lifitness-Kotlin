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
import com.lifitness.common.composable.ExerciseCard
import com.lifitness.common.composable.HealthInstructorCard
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
            ExerciseCard("Agachamento", "1 HORA")
            ExerciseCard("Treino de Perna", "2 HORAS")
            ExerciseCard("Treino de Costa", "1 HORA")
        }
    }
}

@Preview
@Composable
fun defaultPreviewExercises() {
    ExercisesScreen()
}