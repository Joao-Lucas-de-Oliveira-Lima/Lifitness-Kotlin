package com.lifitness.screens.profile

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import com.lifitness.common.composable.DefaultButton
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import com.lifitness.common.composable.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.lifitness.app.LifitnessScreen
import com.lifitness.common.ext.endOfScreenSpacer
import com.lifitness.common.ext.spacer
import com.lifitness.singleton.LoggedInUserSingleton
import com.lifitness.ui.theme.BackgroundColor
import com.lifitness.ui.theme.BackgroundColor as background

@Composable
fun ProfileScreen(
    modifier: Modifier,
    navController: NavHostController
){
    val profileViewModel: ProfileViewModel = viewModel()
    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {
            profileViewModel.photo = it
        }
    )
    val userSingleton = LoggedInUserSingleton.getInstance()
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
            val painter: Painter = rememberImagePainter(user.imageURL)
            ImageBackground()
            Row (horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()){
                ImageProfile(painter)
                Button(onClick = {
                    photoPickerLauncher.launch(
                        PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                ) }, colors = ButtonDefaults.buttonColors(Color.Transparent)) {
                    Icon(
                        Icons.Default.CameraAlt,
                        contentDescription = "Edit profile image",
                        tint = Color.White,
                    )
                }
            }

        }
        BioCard(
            nickname = user.nickname,
            content = user.bio
        )

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()) {
            SettingsTitle()
            Spacer(modifier = Modifier.spacer())
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DefaultButton(
                    contentTitle = "EDIT PROFILE",
                    contentIcon = Icons.Default.Settings,
                    onClick = { navController.navigate(LifitnessScreen.Settings.name) },
                    buttonColor = BackgroundColor
                )
                Spacer(modifier = Modifier.spacer())
                DefaultButton(
                    contentTitle = "LOG OUT",
                    contentIcon = Icons.Default.ExitToApp,
                    onClick = {
                        userSingleton.resetUserData()
                        navController.navigate(LifitnessScreen.Login.name) },
                    buttonColor = BackgroundColor
                )
                Spacer(modifier = Modifier.spacer())
            }
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