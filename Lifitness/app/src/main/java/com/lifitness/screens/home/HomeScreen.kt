package com.lifitness.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lifitness.app.LifitnessScreen
import com.lifitness.common.composable.DietRecomendationCard
import com.lifitness.common.composable.DietsRecomendationTitle
import com.lifitness.common.composable.ExerciseCard
import com.lifitness.common.composable.IntermediateTitle
import com.lifitness.common.ext.endOfScreenSpacer
import com.lifitness.ui.theme.BackgroundColor

@Composable
fun HomeScreen(navController: NavHostController){
    LazyColumn(
        userScrollEnabled = true,
                modifier = Modifier
            .background(BackgroundColor)
            .fillMaxHeight()) {
        item {
            Column {
                IntermediateTitle()
                ExerciseCard("TREINO DE ABDÔMEN", "26 MIN", onClick = { navController.navigate(LifitnessScreen.Train.name) })
                ExerciseCard("TREINO DE PEITO", "15 MIN", onClick = { navController.navigate(LifitnessScreen.Train.name) })
                ExerciseCard("TREINO DE PEITO", "15 MIN", onClick = { navController.navigate(LifitnessScreen.Train.name) })
            }
        }

        item{
            Column {
                DietsRecomendationTitle()
                Row {
                    DietRecomendationCard(exerciseName = "Arroz Branco", "200CAL", onClick = { navController.navigate(LifitnessScreen.Food_Screen.name) })
                    DietRecomendationCard(exerciseName = "Feijão Mulato", "200CAL", onClick = { navController.navigate(LifitnessScreen.Food_Screen.name) })
                    DietRecomendationCard(exerciseName = "Feijão Mulato", "200CAL", onClick = { navController.navigate(LifitnessScreen.Food_Screen.name) })
                }
                Row {
                    DietRecomendationCard(exerciseName = "Arroz Branco", "200CAL", onClick = { navController.navigate(LifitnessScreen.Food_Screen.name) })
                    DietRecomendationCard(exerciseName = "Feijão Mulato", "200CAL", onClick = { navController.navigate(LifitnessScreen.Food_Screen.name) })
                    DietRecomendationCard(exerciseName = "Feijão Mulato", "200CAL", onClick = { navController.navigate(LifitnessScreen.Food_Screen.name) })
                }
            }
        }

        item {
            Spacer(modifier = Modifier.endOfScreenSpacer())
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen(){
    val navController = rememberNavController()
    HomeScreen(navController)
}