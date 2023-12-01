package com.lifitness.screens.register.personalDataRegistration

import ButtonWithoutIconComposable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lifitness.R
import com.lifitness.app.LifitnessScreen
import com.lifitness.common.composable.ClickableLoginTextComponent
import com.lifitness.common.composable.DividerTextComposable
import com.lifitness.common.composable.NormalTextComposable
import com.lifitness.common.composable.RegistrationProgressBarComposable



@Composable
fun PersonalDataRegistrationScreen(navController: NavHostController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.screen_background_color))
    ) {
        val viewModel = viewModel<PersonalDataRegistrationScreenViewModel>()
        val state = viewModel.state
        val context = LocalContext.current
        LaunchedEffect(key1 = context) {
            viewModel.validationEvents.collect { event ->
                when (event) {
                    is PersonalDataRegistrationScreenViewModel.ValidationEvent.Success -> {
                        navController.navigate(LifitnessScreen.GoalRegistration.name)
                    }
                }
            }
        }
        Box(
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(15.dp))
                RegistrationProgressBarComposable(
                    currentStep = 2,
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
                            navController.navigate(LifitnessScreen.Register.name)
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
                //Age field
                OutlinedTextField(
                    value = state.age,
                    onValueChange = {
                        val onlyDigits = it.filter { char -> char.isDigit() }
                        viewModel.onEvent(PersonalDataRegistrationScreenFormEvent.AgeChanged(it))
                    },
                    isError = state.ageError != null,
                    modifier = Modifier
                        .background(Color(35, 33, 33), RoundedCornerShape(12.dp)),
                    label = {
                        Text(
                            text = stringResource(id = R.string.personal_data_registration_screen_age_field),
                            color = Color.White
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        cursorColor = Color.White,
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        focusedLabelColor = Color.White,
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    textStyle = TextStyle(color = Color.White),
                )
                if (state.ageError != null) {
                    Text(
                        text = state.ageError,
                        fontSize = 16.sp,
                        color = MaterialTheme.colors.error,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(horizontal = 50.dp),
                        textAlign = TextAlign.Center
                    )
                }
                //Height field
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = state.height,
                    onValueChange = {
                        val onlyDigits = it.filter { char -> char.isDigit() }
                        viewModel.onEvent(PersonalDataRegistrationScreenFormEvent.HeightChanged(it))
                    },
                    isError = state.heightError != null,
                    modifier = Modifier
                        .background(Color(35, 33, 33), RoundedCornerShape(12.dp)),
                    label = {
                        Text(
                            text = stringResource(id = R.string.personal_data_registration_screen_height_field),
                            color = Color.White
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        cursorColor = Color.White,
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        focusedLabelColor = Color.White,
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    textStyle = TextStyle(color = Color.White),
                )
                if (state.heightError != null) {
                    Text(
                        text = state.heightError,
                        fontSize = 16.sp,
                        color = MaterialTheme.colors.error,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(horizontal = 50.dp),
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = state.weight,
                    onValueChange = {
                        val onlyDigits = it.filter { char -> char.isDigit() }
                        viewModel.onEvent(PersonalDataRegistrationScreenFormEvent.WeightChanged(it))
                    },
                    isError = state.weightError != null,
                    modifier = Modifier
                        .background(Color(35, 33, 33), RoundedCornerShape(12.dp)),
                    label = {
                        Text(
                            text = stringResource(id = R.string.personal_data_registration_screen_weight_field),
                            color = Color.White
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        cursorColor = Color.White,
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        focusedLabelColor = Color.White,
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    textStyle = TextStyle(color = Color.White),
                )
                if (state.weightError != null) {
                    Text(
                        text = state.weightError,
                        fontSize = 16.sp,
                        color = MaterialTheme.colors.error,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(horizontal = 50.dp),
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.height(130.dp))
            }
            Box(
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ButtonWithoutIconComposable(
                        text = stringResource(id = R.string.next_title),
                        textColor = Color.Black,
                        fontSize = 17,
                        minHeight = 30,
                        buttonColor = Color.White,
                        horizontalPadding = 50,
                        onClick = { viewModel.onEvent(PersonalDataRegistrationScreenFormEvent.NextScreen) }
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
    }
}

@Preview
@Composable
fun PreviewPersonalDataRegistrationScreen() {
    val navController = rememberNavController()
    PersonalDataRegistrationScreen(navController)
}