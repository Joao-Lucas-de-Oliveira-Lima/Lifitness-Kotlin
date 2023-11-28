package com.lifitness.screens.editProfile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.lifitness.common.composable.EditTitle
import com.lifitness.common.composable.SmallButton
import com.lifitness.common.composable.TextFieldComponent
import com.lifitness.common.ext.spacer
import com.lifitness.ui.theme.BackgroundColor
import com.lifitness.ui.theme.ButtonEdit

enum class ActivityLevel {
    Sedentary, Low, Medium, High
}

enum class Problems {
    Motivation, Knowledge, Schedule, Guidance
}
enum class Goal {
    LoseWeight, GetStronger, GainMass, BeHealthy
}

val goal: Goal = Goal.GainMass
const val weight: Double = 70.00
const val height: Double = 1.71
val activityLevel: ActivityLevel = ActivityLevel.Sedentary
val problems: Problems = Problems.Guidance
val bio: String = "user bio"



@Composable
fun EditProfileScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(BackgroundColor)
    ) {
        EditTitle()
        Spacer(modifier = Modifier.spacer())
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.spacer())
            TextFieldComponent(labelValue = "Goal")
            Spacer(modifier = Modifier.spacer())
            TextFieldComponent(labelValue = "Weight")
            Spacer(modifier = Modifier.spacer())
            TextFieldComponent(labelValue = "Height")
            Spacer(modifier = Modifier.spacer())
            TextFieldComponent(labelValue = "activityLevel")
            Spacer(modifier = Modifier.spacer())
            TextFieldComponent(labelValue = "What keep you?")
            Spacer(modifier = Modifier.spacer())
            TextFieldComponent(labelValue = "bio")
            Spacer(modifier = Modifier.spacer())
            SmallButton(
                contentTitle = "SALVAR",
                onClick = {  },
                buttonColor = ButtonEdit
            )
        }

    }
}

@Preview
@Composable
fun PreviewEdit() {
    val navController = rememberNavController()
    EditProfileScreen(navController)
}
