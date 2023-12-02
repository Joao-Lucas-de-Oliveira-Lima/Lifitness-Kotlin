package com.lifitness.screens.diets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import com.lifitness.common.composable.DietsRecomendationTitle
import com.lifitness.common.composable.DietsTitle
import com.lifitness.common.composable.HealthInstructorCard
import com.lifitness.common.composable.HireNutricionistTitle
import com.lifitness.common.composable.PersonalDietCard
import com.lifitness.common.composable.PersonalNutricionistTitle
import com.lifitness.common.ext.endOfScreenSpacer
import com.lifitness.common.ext.spacer
import kotlinx.serialization.json.Json
import kotlinx.serialization.*
import com.lifitness.ui.theme.BackgroundColor

@Composable
fun DietsScreen(navController: NavHostController, dietViewModel: DietsViewModel) {
    val dietValues = dietViewModel.diets.observeAsState()

    Box(
        modifier = Modifier
            .background(BackgroundColor)
            .fillMaxSize()
    ) {
        LazyColumn {
            item {
                DietsTitle()
            }
            item {
                Spacer(modifier = Modifier.spacer())
                HireNutricionistTitle()
                LazyRow {
                    items(4) {
                        HealthInstructorCard("Clécia", {})
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.spacer())
                PersonalNutricionistTitle()
                PersonalDietCard("pedro", "carlo")
            }

            item {
                Spacer(modifier = Modifier.spacer())
                DietsRecomendationTitle()
            }

            item {
                LazyRow {
                    if (dietValues.value?.isEmpty() != false) {
                        items(8) {
                            DietRecommendationCard("", "", false) {  }
                        }
                    } else {
                        items(dietValues.value!!) { diet ->
                            DietRecommendationCard(diet.dietName, diet.dietNutricionalTable[0], true) {
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
}

@Preview
@Composable
fun PreviewDietsScreen() {
    val navController = rememberNavController()
    val dietViewModel: DietsViewModel = viewModel()
    DietsScreen(navController, dietViewModel)
}