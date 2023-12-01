package com.lifitness.screens.home.personal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ManageAccounts
import androidx.compose.material.icons.filled.ManageSearch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lifitness.app.LifitnessScreen
import com.lifitness.common.composable.HomeTitle
import com.lifitness.common.composable.PersonalButton
import com.lifitness.common.ext.spacer
import com.lifitness.ui.theme.BackgroundColor

@Composable
fun PersonalHomeScreen(
    navController: NavHostController
){
    Column(modifier = Modifier.fillMaxHeight().fillMaxWidth().background(BackgroundColor)) {
        HomeTitle()
        Spacer(modifier = Modifier.spacer())
        PersonalButton(
            contentTitle = "MANAGE STUDENTS",
            contentIcon = Icons.Default.ManageAccounts,
            onClick = {navController.navigate(LifitnessScreen.ClientsList.name)}
        )
        Spacer(modifier = Modifier.spacer())
        PersonalButton(
            contentTitle = "MANAGE TRAINS",
            contentIcon = Icons.Default.ManageSearch,
            onClick = {navController.navigate(LifitnessScreen.TrainList.name)}
        )
    }
}

@Composable
@Preview
fun PersonalHomeScreenPreview(){
    val navController = rememberNavController()
    PersonalHomeScreen(navController)
}