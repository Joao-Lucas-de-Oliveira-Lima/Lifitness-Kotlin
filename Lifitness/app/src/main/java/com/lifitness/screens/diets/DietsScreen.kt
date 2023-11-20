package com.lifitness.screens.diets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
import com.lifitness.ui.theme.BackgroundColor

@Composable
fun DietsScreen(navController: NavHostController) {
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
                    item {
                        DietRecommendationCard("Arroz Branco", "200CAL", onClick = { navController.navigate(LifitnessScreen.Food_Screen.name) })
                        DietRecommendationCard("Feijão Mulato", "200CAL", onClick = { navController.navigate(LifitnessScreen.Food_Screen.name) })
                        DietRecommendationCard("Frango", "200CAL", onClick = { navController.navigate(LifitnessScreen.Food_Screen.name) })
                        DietRecommendationCard("Carnes Vermelhas", "200CAL", onClick = { navController.navigate(LifitnessScreen.Food_Screen.name) })
                        DietRecommendationCard("Saladas", "200CAL", onClick = { navController.navigate(LifitnessScreen.Food_Screen.name) })
                    }
                }
            }

            item {
                LazyRow {
                    item {
                        DietRecommendationCard("Arroz Branco", "200CAL", onClick = { navController.navigate(LifitnessScreen.Food_Screen.name) })
                        DietRecommendationCard("Feijão Mulato", "200CAL", onClick = { navController.navigate(LifitnessScreen.Food_Screen.name) })
                        DietRecommendationCard("Frango", "200CAL", onClick = { navController.navigate(LifitnessScreen.Food_Screen.name) })
                        DietRecommendationCard("Carnes Vermelhas", "200CAL", onClick = { navController.navigate(LifitnessScreen.Food_Screen.name) })
                        DietRecommendationCard("Saladas", "200CAL", onClick = { navController.navigate(LifitnessScreen.Food_Screen.name) })
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
    DietsScreen(navController)
}