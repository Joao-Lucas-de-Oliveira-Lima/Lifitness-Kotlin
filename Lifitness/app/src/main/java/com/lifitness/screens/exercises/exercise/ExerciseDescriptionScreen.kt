package com.lifitness.screens.exercises.exercise

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lifitness.common.composable.AmountExerciseTitle
import com.lifitness.common.composable.DescriptionTitle
import com.lifitness.common.composable.ExerciseDescription
import com.lifitness.common.composable.ExerciseTitle
import com.lifitness.common.composable.ImageExerciseDescription
import com.lifitness.common.ext.spacer
import com.lifitness.ui.theme.BackgroundColor
import com.lifitness.ui.theme.CardBackground

@Composable
fun ExerciseDescriptionScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .background(BackgroundColor)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Column {
            Row {
                ExerciseTitle("AGACHAMENTO")
            }
            Spacer(modifier = Modifier.spacer())
            ImageExerciseDescription()
            Spacer(modifier = Modifier.spacer())
            DescriptionTitle("Description")
            Column(
                modifier = Modifier
                    .background(CardBackground)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                ExerciseDescription(
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do" +
                            " eiusmod tempor incididunt ut labore et dolore magna aliqua."
                )
                AmountExerciseTitle("4x13")
            }

        }
    }
}

@Preview
@Composable
fun defaultPreviewExerciseDescriptionScreen() {
    val navController = rememberNavController()
    ExerciseDescriptionScreen(navController)
}