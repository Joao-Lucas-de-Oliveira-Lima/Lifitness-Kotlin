package com.lifitness.common.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lifitness.R
import com.lifitness.common.ext.shimmerLoadingAnimation
import com.lifitness.ui.theme.CardBackground

@Composable
fun ExerciseCard(exerciseName: String, exerciseDuration: String, isLoading: Boolean, onClick: () -> Unit) {
    EditorExerciseCard(exerciseName, exerciseDuration, isLoading, onClick)
}

@Composable
fun EditorExerciseCard(exerciseName: String, exerciseDuration: String, isLoading: Boolean, onClick: () -> Unit) {
    Box (
        modifier = Modifier
            .clickable(onClick = { onClick() })
            .testTag("exercise_card")
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .padding(10.dp)
                .clip(RoundedCornerShape(15)),
            colors = CardDefaults.cardColors(
                containerColor = CardBackground
            )
        ) {
            Row {
                if(!isLoading) {
                    ImageExercise()
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .shimmerLoadingAnimation(!isLoading),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if(!isLoading) {
                        SpecificTrainTitle(exerciseName)
                        SpecificTrainDuration(exerciseDuration)
                    }
                }
            }
        }
    }
}

@Composable
fun ImagePersonalTrain() {
    Image(
        painter = painterResource(R.drawable.exercises_perfoming),
        contentScale = ContentScale.FillBounds,
        contentDescription = "Exercise picture",
        modifier = Modifier
            .fillMaxSize()
            .blur(100.dp),

        )
}



@Preview
@Composable
fun PreviewExerciseCard() {
    ExerciseCard(exerciseName = "Treino de Perna", exerciseDuration = "2 horas", true, {})
}

@Preview
@Composable
fun PreviewPersonalTrainCard() {
    ImagePersonalTrain()
}