package com.lifitness.screens.profile

import com.lifitness.common.composable.DefaultButton
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import com.lifitness.common.composable.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lifitness.common.ext.endOfScreenSpacer
import com.lifitness.common.ext.spacer
import com.lifitness.ui.theme.BackgroundColor
import com.lifitness.ui.theme.BackgroundColor as background

@Composable
fun ProfileScreen(
    modifier: Modifier,
    navController: NavHostController
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
            .background(background),
        horizontalAlignment = Alignment.Start
        
    ){
        Row {
            MoreTitle()
        }
        Spacer(modifier = Modifier.spacer())
        Box {
            ImageBackground()
            Row (horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()){
                ImageProfile()
                Icon(
                    Icons.Default.Create,
                    contentDescription = "Edit profile image",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .padding(end = 10.dp)
                )
            }

        }
        BioCard(
            nickname = "Pedro Marcelo",
            content = "My story begins with the Lifitness app, which has been my trusty companion on this fitness adventure. I believe that age is just a number, and with the right tools and mindset, we can all live life to the fullest."
        )

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()) {
            SettingsTitle()
            Spacer(modifier = Modifier.spacer())
            DefaultButton(
                contentTitle = "EDIT PROFILE",
                contentIcon = Icons.Default.Settings,
                onClick = { /*TODO*/ },
                buttonColor = BackgroundColor
            )
            Spacer(modifier = Modifier.spacer())
            DefaultButton(
                contentTitle = "ACCOUNT",
                contentIcon = Icons.Default.Person,
                onClick = { /*TODO*/ },
                buttonColor = BackgroundColor
            )
            Spacer(modifier = Modifier.spacer())
            DefaultButton(
                contentTitle = "LOG OUT",
                contentIcon = Icons.Default.ExitToApp,
                onClick = { /*TODO*/ },
                buttonColor = BackgroundColor
            )
            Spacer(modifier = Modifier.spacer())
        }

        Spacer(modifier = Modifier.endOfScreenSpacer())

    }
}

@Preview
@Composable
fun PreviewProfileScreen(){
    val navController = rememberNavController()
    ProfileScreen(modifier = Modifier, navController)
}