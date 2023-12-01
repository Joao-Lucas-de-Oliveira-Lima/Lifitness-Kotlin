package com.lifitness.screens.trains.exercise

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
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lifitness.common.composable.AmountExerciseTitle
import com.lifitness.common.composable.DescriptionTitle
import com.lifitness.common.composable.ExerciseDescription
import com.lifitness.common.composable.ExerciseTitle
import com.lifitness.common.composable.ImageExerciseDescription
import com.lifitness.common.composable.YoutubeVideoPlayer
import com.lifitness.common.ext.endOfScreenSpacer
import com.lifitness.common.ext.spacer
import com.lifitness.model.Exercise
import com.lifitness.ui.theme.BackgroundColor
import com.lifitness.ui.theme.CardBackground

@Composable
fun ExerciseDescriptionScreen(navController: NavHostController, exerciseDescription: Exercise) {
    exerciseDescription.decode()
    Box(
        modifier = Modifier
            .background(BackgroundColor)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Column {
            Row {
                ExerciseTitle(exerciseDescription.exerciseName)
            }
            Spacer(modifier = Modifier.spacer())
            YoutubeVideoPlayer(
                youtubeVideoId = exerciseDescription.videoURL,
                lifecycleOwner = LocalLifecycleOwner.current
            )
            Spacer(modifier = Modifier.spacer())
            DescriptionTitle("Description")
            Column(
                modifier = Modifier
                    .background(CardBackground)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                ExerciseDescription(exerciseDescription.exerciseDescription)
                AmountExerciseTitle(exerciseDescription.exerciseDuration)
            }
            Spacer(modifier = Modifier.endOfScreenSpacer())
        }
    }
}

@Preview
@Composable
fun defaultPreviewExerciseDescriptionScreen() {
    val navController = rememberNavController()
    val exercise = Exercise()
    ExerciseDescriptionScreen(navController, exercise)
}