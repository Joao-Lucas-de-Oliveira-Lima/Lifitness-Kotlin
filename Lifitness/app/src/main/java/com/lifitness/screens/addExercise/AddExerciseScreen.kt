package com.lifitness.screens.addExercise

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lifitness.app.LifitnessScreen
import com.lifitness.common.composable.AddExerciseTitle
import com.lifitness.common.composable.SmallButton
import com.lifitness.common.composable.TextFieldComponent
import com.lifitness.common.ext.endOfScreenSpacer
import com.lifitness.common.ext.spacer
import com.lifitness.ui.theme.BackgroundColor
import com.lifitness.ui.theme.CardBackground

@Composable
fun AddExerciseScreen(navController: NavHostController){
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        selectedImageUri = uri
    }
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .fillMaxHeight()
            .background(BackgroundColor)
    ) {
        AddExerciseTitle()
        Spacer(modifier = Modifier.spacer())
        Button(
            shape = RoundedCornerShape(0),
            onClick = { pickImage(launcher) },
            colors = ButtonDefaults.buttonColors(CardBackground),
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(imageVector = Icons.Default.Upload, tint = Color.Gray ,contentDescription = "Upload image", modifier = Modifier.size(100.dp))
                Text("Select an image", fontSize = 20.sp, color = Color.Gray)
            }
        }
        Spacer(modifier = Modifier.endOfScreenSpacer())
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            TextFieldComponent(labelValue = "Name")
            Spacer(modifier = Modifier.spacer())
            TextFieldComponent(labelValue = "Muscle Target")
            Spacer(modifier = Modifier.spacer())
            SmallButton(contentTitle = "ADD", onClick = { navController.navigate(LifitnessScreen.AddTrain.name) }, buttonColor = CardBackground)
        }
        Spacer(modifier = Modifier.endOfScreenSpacer())
    }
}

fun pickImage(launcher: ActivityResultLauncher<String>) {
    launcher.launch("image/*")
}

@Preview
@Composable
fun AddExerciseScreenPreview(){
    val navController = rememberNavController()
    AddExerciseScreen(navController)
}