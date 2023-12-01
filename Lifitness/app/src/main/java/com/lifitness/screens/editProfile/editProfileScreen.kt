package com.lifitness.screens.editProfile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
import com.lifitness.singleton.LoggedInUserSingleton
import com.lifitness.ui.theme.BackgroundColor
import com.lifitness.ui.theme.ButtonEdit
import com.lifitness.ui.theme.CardBackground
import com.lifitness.ui.theme.RedChart
import com.lifitness.ui.theme.TextColor
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen(navController: NavHostController) {
    val editProfileViewModel: EditProfileViewModel = EditProfileViewModel()
    val userSingleton = LoggedInUserSingleton
    var goal by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var aLevel by remember { mutableStateOf("") }
    var wKeep by remember { mutableStateOf("") }
    var bio by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()
    suspend fun handleSave(){
        navController.navigate(LifitnessScreen.Profile.name)
        editProfileViewModel.updateUser(goal, height, weight, aLevel, wKeep, bio)
    }

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
            OutlinedTextField(
                value = goal,
                onValueChange = { goal = it },
                label = { Text(text="Goal", color = Color.Gray) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.White,
                    focusedBorderColor = Color.White,
                    focusedLabelColor = Color.White,
                    cursorColor = Color.White,
                ),
                keyboardOptions = KeyboardOptions.Default,
                textStyle = androidx.compose.ui.text.TextStyle(color = Color.White)

            )
            Spacer(modifier = Modifier.spacer())
            OutlinedTextField(
                value = height,
                onValueChange = { height = it },
                label = { Text(text="Height", color = Color.Gray) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.White,
                    focusedBorderColor = Color.White,
                    focusedLabelColor = Color.White,
                    cursorColor = Color.White,
                ),
                keyboardOptions = KeyboardOptions.Default,
                textStyle = androidx.compose.ui.text.TextStyle(color = Color.White)
            )
            Spacer(modifier = Modifier.spacer())
            OutlinedTextField(
                value = weight,
                onValueChange = { weight = it },
                label = { Text(text="Weight", color = Color.Gray) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.White,
                    focusedBorderColor = Color.White,
                    focusedLabelColor = Color.White,
                    cursorColor = Color.White,
                ),
                keyboardOptions = KeyboardOptions.Default,
                textStyle = androidx.compose.ui.text.TextStyle(color = Color.White)
            )
            Spacer(modifier = Modifier.spacer())
            OutlinedTextField(
                value = aLevel,
                onValueChange = { aLevel = it },
                label = { Text(text="Activity level", color = Color.Gray) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.White,
                    focusedBorderColor = Color.White,
                    focusedLabelColor = Color.White,
                    cursorColor = Color.White,
                ),
                keyboardOptions = KeyboardOptions.Default,
                textStyle = androidx.compose.ui.text.TextStyle(color = Color.White)
            )
            Spacer(modifier = Modifier.spacer())
            OutlinedTextField(
                value = wKeep,
                onValueChange = { wKeep = it },
                label = { Text(text="What keep you from working-out?", color = Color.Gray) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.White,
                    focusedBorderColor = Color.White,
                    focusedLabelColor = Color.White,
                    cursorColor = Color.White,
                ),
                keyboardOptions = KeyboardOptions.Default,
                textStyle = androidx.compose.ui.text.TextStyle(color = Color.White)
            )
            Spacer(modifier = Modifier.spacer())
            OutlinedTextField(
                value = bio,
                onValueChange = { bio = it },
                label = { Text(text="Biography", color = Color.Gray) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.White,
                    focusedBorderColor = Color.White,
                    focusedLabelColor = Color.White,
                    cursorColor = Color.White,
                ),
                keyboardOptions = KeyboardOptions.Default,
                textStyle = androidx.compose.ui.text.TextStyle(color = Color.White)
            )
            Spacer(modifier = Modifier.spacer())
            SmallButton(
                contentTitle = "SALVAR",
                onClick = {
                    coroutineScope.launch {
                        handleSave()
                    }
                },
                buttonColor = ButtonEdit
            )
            Spacer(modifier = Modifier.endOfScreenSpacer())
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
