package com.lifitness.common.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lifitness.ui.theme.CardBackground

@Composable
fun ExerciseCard(exerciseName: String, exerciseDuration: String) {
    EditorExerciseCard(exerciseName, exerciseDuration)
}

@Composable
fun EditorExerciseCard(exerciseName: String, exerciseDuration: String) {
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
            ImageExercise()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SpecificTrainTitle(exerciseName)
                SpecificTrainDuration(exerciseDuration)
            }
        }
    }
}



@Preview
@Composable
fun PreviewExerciseCard() {
    ExerciseCard(exerciseName = "Treino de Perna", exerciseDuration = "2 horas")
}