package com.lifitness.screens.register.impedimentsRegistration

import ButtonWithoutIconComposable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lifitness.R
import com.lifitness.app.LifitnessScreen
import com.lifitness.common.composable.ClickableLoginTextComponent
import com.lifitness.common.composable.DividerTextComposable
import com.lifitness.common.composable.NormalTextComposable
import com.lifitness.common.composable.RegistrationProgressBarComposable
import com.lifitness.singleton.LoggedInUserSingleton

data class Option(val labelId: Int, val imageId: Int, val descriptionAsString: String)

@Composable
fun ImpedimentsRegistrationScreen(navController: NavHostController) {
    val options = listOf(
        Option(labelId = R.string.no_motivation_option, imageId = R.drawable.no_motivation, "No motivation"),
        Option(labelId = R.string.lack_of_knowledge_option, imageId = R.drawable.lack_of_knowledge, "Lack of knowledge"),
        Option(labelId = R.string.busy_schedule_option, imageId = R.drawable.busy_schedule, "Busy schedule"),
        Option(labelId = R.string.not_enough_guidance_option, imageId = R.drawable.not_enough_guidance, "Not enough guidance")
    )
    var selectedOption by remember { mutableStateOf(options[0]) }
    val userSingleton = LoggedInUserSingleton.getInstance()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.screen_background_color))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            RegistrationProgressBarComposable(
                currentStep = 5,
                totalSteps = 5,
                Color(255, 102, 102),
                160
            )
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                //verticalAlignment = Alignment.CenterVertically
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(
                    onClick = {
                        navController.navigate(LifitnessScreen.PhysicalActivityLevel.name)
                    },
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .background(Color.Transparent), // Define o background como transparente
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIosNew,
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier
                            .size(40.dp)
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.lifitnesslogo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .heightIn(min = 60.dp)
                        .widthIn(min = 70.dp)
                        .align(Alignment.TopCenter)
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            NormalTextComposable(
                text = stringResource(id = R.string.personal_data_registration_screen_greeting_text),
                fontSize = 15,
                color = Color.White,
                horizontalPadding = 50
            )
            Spacer(modifier = Modifier.height(10.dp))
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                options.forEach { option ->
                    Row(
                        modifier = Modifier
                            .clickable {
                                //todo
                                userSingleton.impediments = option.descriptionAsString
                                selectedOption = option }
                            .padding(5.dp)
                            .width(240.dp)
                            .height(70.dp)
                            .background(
                                if (option == selectedOption) Color.LightGray else Color.Transparent,
                                RoundedCornerShape(16.dp)
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start

                    ) {
                        Image(
                            painter = painterResource(option.imageId),
                            contentDescription = "Logo",
                            modifier = Modifier
                                .heightIn(min = 60.dp)
                                .widthIn(min = 70.dp)

                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = stringResource(id = option.labelId),
                            fontWeight = FontWeight.Bold,
                            color = (if (option == selectedOption) Color.Black else Color.White)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(60.dp))
            ButtonWithoutIconComposable(
                text = stringResource(id = R.string.finish_title),
                textColor = Color.Black,
                fontSize = 17,
                minHeight = 30,
                buttonColor = Color.White,
                horizontalPadding = 50
            ) {
                navController.navigate(LifitnessScreen.Home.name)
            }
            Spacer(modifier = Modifier.height(5.dp))
            DividerTextComposable(
                text = stringResource(id = R.string.divisive_text),
                fontSize = 18,
                color = Color.White,
                thickness = 1
            )
            ClickableLoginTextComponent(
                text = stringResource(id = R.string.create_an_account_text)
            ) { navController.navigate(LifitnessScreen.Login.name) }
            Spacer(modifier = Modifier.height(5.dp))
        }
    }
}

@Preview
@Composable
fun ImpedimentsRegistrationScreenPreview(){
    val navController = rememberNavController()
    ImpedimentsRegistrationScreen(navController);
}