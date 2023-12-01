package com.lifitness.screens.personalClient

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.lifitness.R
import com.lifitness.app.LifitnessScreen
import com.lifitness.common.composable.ImageProfile
import com.lifitness.common.composable.SmallButton
import com.lifitness.common.ext.endOfScreenSpacer
import com.lifitness.common.ext.spacer
import com.lifitness.model.Client
import com.lifitness.model.createSingleMock
import com.lifitness.ui.theme.BackgroundColor
import com.lifitness.ui.theme.ButtonEdit
import com.lifitness.ui.theme.CardBackground
import com.lifitness.ui.theme.TextColor
val user: Client = createSingleMock()
@Composable
fun PersonalClientScreen(user: Client, imageId: Int, navController: NavHostController){
    Column(modifier = Modifier
        .background(BackgroundColor)
        .fillMaxHeight()
        .verticalScroll(rememberScrollState())
        .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.spacer())
        val painter: Painter = rememberImagePainter(user.imageURL)
        ImageProfile(painter)
        Text(text = user.nickname, color = TextColor, fontSize = 24.sp)
        Spacer(modifier = Modifier.spacer())
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TextField(
                value = user.bio,
                readOnly = true,
                onValueChange = {},
                label = { Text("Biography", Modifier.background(CardBackground), TextColor, fontWeight = FontWeight.Bold) },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = TextColor, // Cor do texto
                    backgroundColor = CardBackground, // Cor de fundo
                    cursorColor = Color.White, // Cor do cursor
                    focusedIndicatorColor = Color.Green, // Cor da linha de foco
                    unfocusedIndicatorColor = Color.Gray, // Cor da linha quando não está em foco
                    disabledIndicatorColor = Color.Red, // Cor da linha quando desabilitado
                    errorIndicatorColor = Color.Red // Cor da linha quando há erro
            ))
            Spacer(modifier = Modifier.spacer())
            TextField(
                value = user.goal,
                readOnly = true,
                onValueChange = {},
                label = { Text("Goal", Modifier.background(CardBackground), TextColor, fontWeight = FontWeight.Bold) },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = TextColor, // Cor do texto
                    backgroundColor = CardBackground, // Cor de fundo
                    cursorColor = Color.White, // Cor do cursor
                    focusedIndicatorColor = Color.Green, // Cor da linha de foco
                    unfocusedIndicatorColor = Color.Gray, // Cor da linha quando não está em foco
                    disabledIndicatorColor = Color.Red, // Cor da linha quando desabilitado
                    errorIndicatorColor = Color.Red // Cor da linha quando há erro
                ))
            Spacer(modifier = Modifier.spacer())
            TextField(
                value = user.height.toString(),
                readOnly = true,
                onValueChange = {},
                label = { Text("Height", Modifier.background(CardBackground), TextColor, fontWeight = FontWeight.Bold) },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = TextColor, // Cor do texto
                    backgroundColor = CardBackground, // Cor de fundo
                    cursorColor = Color.White, // Cor do cursor
                    focusedIndicatorColor = Color.Green, // Cor da linha de foco
                    unfocusedIndicatorColor = Color.Gray, // Cor da linha quando não está em foco
                    disabledIndicatorColor = Color.Red, // Cor da linha quando desabilitado
                    errorIndicatorColor = Color.Red // Cor da linha quando há erro
                ))
            Spacer(modifier = Modifier.spacer())
            TextField(
                value = user.weight.toString(),
                readOnly = true,
                onValueChange = {},
                label = { Text("Weight", Modifier.background(CardBackground), TextColor, fontWeight = FontWeight.Bold) },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = TextColor, // Cor do texto
                    backgroundColor = CardBackground, // Cor de fundo
                    cursorColor = Color.White, // Cor do cursor
                    focusedIndicatorColor = Color.Green, // Cor da linha de foco
                    unfocusedIndicatorColor = Color.Gray, // Cor da linha quando não está em foco
                    disabledIndicatorColor = Color.Red, // Cor da linha quando desabilitado
                    errorIndicatorColor = Color.Red // Cor da linha quando há erro
                ))
            Spacer(modifier = Modifier.spacer())
            TextField(
                value = user.physicLevel,
                readOnly = true,
                onValueChange = {},
                label = { Text("Level of physical activity", Modifier.background(CardBackground), TextColor, fontWeight = FontWeight.Bold) },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = TextColor, // Cor do texto
                    backgroundColor = CardBackground, // Cor de fundo
                    cursorColor = Color.White, // Cor do cursor
                    focusedIndicatorColor = Color.Green, // Cor da linha de foco
                    unfocusedIndicatorColor = Color.Gray, // Cor da linha quando não está em foco
                    disabledIndicatorColor = Color.Red, // Cor da linha quando desabilitado
                    errorIndicatorColor = Color.Red // Cor da linha quando há erro
                ))
            Spacer(modifier = Modifier.spacer())
            TextField(
                value = user.whatKeep,
                readOnly = true,
                onValueChange = {},
                label = { Text("Problems", Modifier.background(CardBackground), TextColor, fontWeight = FontWeight.Bold) },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = TextColor, // Cor do texto
                    backgroundColor = CardBackground, // Cor de fundo
                    cursorColor = Color.White, // Cor do cursor
                    focusedIndicatorColor = Color.Green, // Cor da linha de foco
                    unfocusedIndicatorColor = Color.Gray, // Cor da linha quando não está em foco
                    disabledIndicatorColor = Color.Red, // Cor da linha quando desabilitado
                    errorIndicatorColor = Color.Red // Cor da linha quando há erro
                ))
            Spacer(modifier = Modifier.spacer())
            SmallButton(contentTitle = "SET TRAIN", onClick = { navController.navigate(LifitnessScreen.TrainList.name) }, buttonColor = ButtonEdit)
            Spacer(modifier = Modifier.endOfScreenSpacer())
        }

    }
}

@Preview
@Composable
fun PersonalClientScreenPreview(){
    val navController = rememberNavController()
    PersonalClientScreen(createSingleMock(), R.drawable.image_16, navController)
}