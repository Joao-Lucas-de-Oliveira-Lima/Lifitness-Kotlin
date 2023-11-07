package com.lifitness.screens.diets

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lifitness.common.composable.DietRecomendationCard
import com.lifitness.common.composable.DietsRecomendationTitle
import com.lifitness.common.composable.DietsTitle
import com.lifitness.common.composable.HealthInstructorCard
import com.lifitness.common.composable.HireNutricionistTitle
import com.lifitness.common.composable.PersonalDietCard
import com.lifitness.common.composable.PersonalNutricionistTitle
import com.lifitness.common.ext.spacer
import com.lifitness.ui.theme.BackgroundColor

@Composable
fun DietsScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .background(BackgroundColor)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Column {
            Row {
                DietsTitle()
            }
            Spacer(modifier = Modifier.spacer())
            HireNutricionistTitle()

            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
            ) {
                HealthInstructorCard(exerciseName = "Paula")
                HealthInstructorCard(exerciseName = "Carlos")
                HealthInstructorCard(exerciseName = "Carlos")
                HealthInstructorCard(exerciseName = "Carlos")
                HealthInstructorCard(exerciseName = "Carlos")
            }

            Spacer(modifier = Modifier.spacer())
            PersonalNutricionistTitle()
            PersonalDietCard("pedro", "carlo")

            Spacer(modifier = Modifier.spacer())
            DietsRecomendationTitle()
            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
            ) {
                DietRecomendationCard(exerciseName = "Arroz Branco", "200CAL")
                DietRecomendationCard(exerciseName = "Feijão Mulato", "200CAL")
                DietRecomendationCard(exerciseName = "Frango", "200CAL")
                DietRecomendationCard(exerciseName = "Carnes Vermelhas", "200CAL")
                DietRecomendationCard(exerciseName = "Saladas", "200CAL")
            }
            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
            ) {
                DietRecomendationCard(exerciseName = "Arroz Branco", "200CAL")
                DietRecomendationCard(exerciseName = "Feijão Mulato", "200CAL")
                DietRecomendationCard(exerciseName = "Frango", "200CAL")
                DietRecomendationCard(exerciseName = "Carnes Vermelhas", "200CAL")
                DietRecomendationCard(exerciseName = "Saladas", "200CAL")
            }
            Spacer(modifier = Modifier.spacer())
            DietsRecomendationTitle()
            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
            ) {
                DietRecomendationCard(exerciseName = "Arroz Branco", "200CAL")
                DietRecomendationCard(exerciseName = "Feijão Mulato", "200CAL")
                DietRecomendationCard(exerciseName = "Frango", "200CAL")
                DietRecomendationCard(exerciseName = "Carnes Vermelhas", "200CAL")
                DietRecomendationCard(exerciseName = "Saladas", "200CAL")
            }
            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
            ) {
                DietRecomendationCard(exerciseName = "Arroz Branco", "200CAL")
                DietRecomendationCard(exerciseName = "Feijão Mulato", "200CAL")
                DietRecomendationCard(exerciseName = "Frango", "200CAL")
                DietRecomendationCard(exerciseName = "Carnes Vermelhas", "200CAL")
                DietRecomendationCard(exerciseName = "Saladas", "200CAL")
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