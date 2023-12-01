package com.lifitness.screens.exerciseList

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lifitness.app.LifitnessScreen
import com.lifitness.common.composable.ExerciseListTitle
import com.lifitness.common.composable.ImageExercise
import com.lifitness.common.composable.SpecificTrainTitle
import com.lifitness.common.ext.smallSpacer
import com.lifitness.common.ext.spacer
import com.lifitness.ui.theme.BackgroundColor
import com.lifitness.ui.theme.CardBackground
import com.lifitness.ui.theme.CardGreen
import com.lifitness.ui.theme.RedChart

@Composable
fun ExerciseListScreen(navController: NavHostController){
    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(BackgroundColor)
    ){
        item {
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                ExerciseListTitle()
                Button(
                    onClick = { navController.navigate(LifitnessScreen.AddExercise.name) },
                    colors = ButtonDefaults.buttonColors(BackgroundColor),
                    border = BorderStroke(2.dp, CardGreen),
                    modifier = Modifier
                        .padding(top = 10.dp, end = 20.dp)
                ) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "Add exercise button",
                        tint = CardGreen,
                    )
                }
            }
            Spacer(modifier = Modifier.spacer())
        }
        items(5) {
            ExerciseCardTrue(exerciseName = "BULGARIAN", {})
            Spacer(modifier = Modifier.spacer())
        }
        item {
            Spacer(modifier = Modifier.smallSpacer())
        }
    }
}

@Composable
fun ExerciseCardTrue(exerciseName: String, deleteOnClick: () -> Unit){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .clip(RoundedCornerShape(15)),
        colors = CardDefaults.cardColors(
            containerColor = CardBackground
        )
    ) {
        Row {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxHeight()
            ) {
                ImageExercise()
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .fillMaxWidth()
                        .fillMaxHeight(),
                ) {
                    SpecificTrainTitle(exerciseName)
                    Button(
                        modifier = Modifier.fillMaxHeight(),
                        onClick = deleteOnClick,
                        colors = ButtonDefaults.buttonColors(Color.Transparent)) {
                        Icon(
                            Icons.Default.Delete,
                            contentDescription = "Delete exercise button",
                            tint = RedChart,
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun ExerciseCardPreview(){
    ExerciseCardTrue(exerciseName = "BULGARIAN", deleteOnClick = {})
}

@Composable
@Preview
fun ExerciseListScreenPreview(){
    val navController = rememberNavController()
    ExerciseListScreen(navController)
}