package com.lifitness.screens.exerciseList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lifitness.common.composable.ExerciseCard
import com.lifitness.common.composable.ExerciseListTitle
import com.lifitness.common.composable.ImageExercise
import com.lifitness.common.composable.SpecificTrainDuration
import com.lifitness.common.composable.SpecificTrainTitle
import com.lifitness.common.ext.smallSpacer
import com.lifitness.common.ext.spacer
import com.lifitness.ui.theme.CardBackground

@Composable
fun ExerciseListScreen(){
    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()){
        item {
            ExerciseListTitle()
            Spacer(modifier = Modifier.spacer())
        }
        items(5){
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = CardBackground),
            ) {
                ExerciseCardTrue(exerciseName = "BULGARIAN")
            }
        }
        item {
            Spacer(modifier = Modifier.smallSpacer())
        }
    }
}

@Composable
fun ExerciseCardTrue(exerciseName: String){
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
            }
        }
    }
}

@Composable
@Preview
fun ExerciseCardPreview(){
    ExerciseCardTrue(exerciseName = "BULGARIAN")
}

@Composable
@Preview
fun ExerciseListScreenPreview(){
    ExerciseListScreen()
}