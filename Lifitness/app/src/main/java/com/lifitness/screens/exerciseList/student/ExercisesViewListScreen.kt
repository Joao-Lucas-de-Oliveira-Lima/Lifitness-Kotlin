package com.lifitness.screens.exerciseList.student

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lifitness.app.LifitnessScreen
import com.lifitness.common.composable.ExerciseCard
import com.lifitness.common.composable.ExerciseListTitle
import com.lifitness.common.ext.smallSpacer
import com.lifitness.common.ext.spacer
import com.lifitness.model.Train

import com.lifitness.ui.theme.BackgroundColor

@Composable
fun ExerciseViewListScreen(navController: NavHostController, trainId: Train){
    val exercisesViewModelList: ExerciseListViewModel = viewModel()
    exercisesViewModelList.fetchExercisesForTrain(trainId.trainId)
    val exercises = exercisesViewModelList.exercises.observeAsState()

    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(BackgroundColor)
    ){
        item {
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                ExerciseListTitle()
            }
            Spacer(modifier = Modifier.spacer())
        }

        item {
            Spacer(modifier = Modifier.smallSpacer())
        }

        exercises.value?.chunked(12) { chunk ->
            items(chunk) { exerciseAdept ->
                ExerciseCard(exerciseAdept.exerciseName, exerciseAdept.exerciseDuration) {
                    navController.navigate(LifitnessScreen.Train.name)
                }
            }
        }
    }
}

@Composable
@Preview
fun ExerciseListScreenPreview(){
    val navController = rememberNavController()
    val train: Train = Train()
    ExerciseViewListScreen(navController,  train)
}