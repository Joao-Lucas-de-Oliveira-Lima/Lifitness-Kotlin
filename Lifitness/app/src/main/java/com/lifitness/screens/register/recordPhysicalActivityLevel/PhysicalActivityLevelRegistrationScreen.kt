package com.lifitness.screens.register.recordPhysicalActivityLevel

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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lifitness.R
import com.lifitness.app.LifitnessScreen
import com.lifitness.common.composable.ClickableLoginTextComponent
import com.lifitness.common.composable.DividerTextComposable
import com.lifitness.common.composable.NormalTextComposable
import com.lifitness.common.composable.RegistrationProgressBarComposable
import com.lifitness.singleton.LoggedInUserSingleton

data class Option(val labelId: Int, val descriptionId: Int, val imageId: Int, val descriptionAsString: String)

@Composable
fun PhysicalActivityLevelRegistrationScreen(navController: NavHostController) {
    val userSingleton = LoggedInUserSingleton.getInstance()
    val options = listOf(
        Option(
            labelId = R.string.sedentary_option,
            descriptionId = R.string.almost_no_exercise_description,
            imageId = R.drawable.sedentary,
            "Sedentary"
        ),
        Option(
            labelId = R.string.slightly_active_option,
            descriptionId = R.string.up_to_2_hours_of_exercise_per_week_description,
            imageId = R.drawable.slightly_active,
            "Slightly active"
        ),
        Option(
            labelId = R.string.active_option,
            descriptionId = R.string.up_to_4_hours_of_exercise_per_week_description,
            imageId = R.drawable.active,
            "Active"
        ),
        Option(
            labelId = R.string.very_active_option,
            descriptionId = R.string.more_than_4_hours_of_exercise_per_week_description,
            imageId = R.drawable.very_active,
            "Very active"
        )
    )
    var selectedOption by remember { mutableStateOf(options[0]) }

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
                currentStep = 4,
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
                        navController.navigate(LifitnessScreen.GoalRegistration.name)
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
                                userSingleton.activityLevel = option.descriptionAsString
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
                        Column(

                        ) {
                            Text(
                                text = stringResource(id = option.labelId),
                                fontWeight = FontWeight.Bold,
                                color = (if (option == selectedOption) Color.Black else Color.White)
                            )
                            Text(
                                text = stringResource(id = option.descriptionId),
                                fontSize = 10.sp,
                                color = (if (option == selectedOption) Color.Black else Color.White)
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(60.dp))
            ButtonWithoutIconComposable(
                text = stringResource(id = R.string.next_title),
                textColor = Color.Black,
                fontSize = 17,
                minHeight = 30,
                buttonColor = Color.White,
                horizontalPadding = 50,
                onClick = {
                    navController.navigate(LifitnessScreen.ImpedimentsRegistration.name)
                }
            )
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
fun PhysicalActivityLevelRegistrationScreenPreview() {
    val navController = rememberNavController()
    PhysicalActivityLevelRegistrationScreen(navController)
}