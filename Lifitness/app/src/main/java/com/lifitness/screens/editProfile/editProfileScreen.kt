package com.lifitness.screens.editProfile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.lifitness.app.LifitnessScreen
import com.lifitness.common.composable.EditTitle
import com.lifitness.common.composable.SmallButton
import com.lifitness.common.composable.TextFieldComponent
import com.lifitness.common.ext.endOfScreenSpacer
import com.lifitness.common.ext.spacer
import com.lifitness.ui.theme.BackgroundColor
import com.lifitness.ui.theme.ButtonEdit




@Composable
fun EditProfileScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(BackgroundColor)
            .verticalScroll(rememberScrollState())
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
            TextFieldComponent(labelValue = "Activity Level")
            Spacer(modifier = Modifier.spacer())
            TextFieldComponent(labelValue = "What keep you from working-out?")
            Spacer(modifier = Modifier.spacer())
            TextFieldComponent(labelValue = "Bio")
            Spacer(modifier = Modifier.spacer())
            SmallButton(
                contentTitle = "SALVAR",
                onClick = { navController.navigate(LifitnessScreen.Profile.name) },
                buttonColor = ButtonEdit
            )
            Spacer(modifier = Modifier.endOfScreenSpacer())
        }

    }
}

@Preview
@Composable
fun PreviewEdit() {
    val navController = rememberNavController()
    EditProfileScreen(navController)
}
