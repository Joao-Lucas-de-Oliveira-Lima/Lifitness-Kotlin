package com.lifitness.screens.home.client

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lifitness.app.LifitnessScreen
import com.lifitness.common.composable.DietRecommendationCard
import com.lifitness.common.composable.ExerciseCard
import com.lifitness.common.composable.HomeTitle
import com.lifitness.common.ext.endOfScreenSpacer
import com.lifitness.common.ext.spacer
import com.lifitness.screens.diets.DietsViewModel
import com.lifitness.ui.theme.BackgroundColor
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Composable
fun HomeScreen(navController: NavHostController){
    val dietViewModel: DietsViewModel = viewModel()
    val dietValues = dietViewModel.diets.observeAsState()

    LazyColumn(
        userScrollEnabled = true,
                modifier = Modifier
                    .background(BackgroundColor)
                    .fillMaxHeight()) {
        item {
            HomeTitle()
            Spacer(modifier = Modifier.spacer())
        }

        item {
            Column {
                ExerciseCard("TREINO DE ABDÔMEN", "26 MIN", onClick = { navController.navigate(LifitnessScreen.Train.name) })
                ExerciseCard("TREINO DE PEITO", "15 MIN", onClick = { navController.navigate(LifitnessScreen.Train.name) })
                ExerciseCard("TREINO DE PEITO", "15 MIN", onClick = { navController.navigate(LifitnessScreen.Train.name) })
            }
        }

        item {
            Spacer(modifier = Modifier.spacer())
            DietsRecomendationTitle()
            LazyRow {
                dietValues.value?.chunked(4) { chunk ->
                    items(chunk) { diet ->
                        DietRecommendationCard(diet.dietName, diet.dietNutricionalTable[0]) {
                            navController.navigate("${LifitnessScreen.Food_Screen.name}/${Json.encodeToString(diet)}")
                        }
                    }
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