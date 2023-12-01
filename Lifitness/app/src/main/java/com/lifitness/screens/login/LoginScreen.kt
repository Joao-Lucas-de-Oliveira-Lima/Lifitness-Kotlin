package com.lifitness.screens.login

import ButtonWithoutIconComposable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lifitness.R
import com.lifitness.app.LifitnessScreen
import com.lifitness.common.composable.ClickableDontHaveAnAccountTextComponent
import com.lifitness.common.composable.ClickableForgotYouPasswordTextComponent
import com.lifitness.common.composable.DividerTextComposable
import com.lifitness.common.composable.FacebookLoginButton
import com.lifitness.common.composable.GoogleLoginButton
import com.lifitness.common.composable.LogoComponent
import com.lifitness.common.composable.NormalTextComposable
import com.lifitness.model.createSingleMock
import com.lifitness.singleton.LoggedInUserSingleton

val user = createSingleMock()

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun LoginScreen(navController: NavHostController) {
    val userSingleton = LoggedInUserSingleton.getInstance()
    var isPasswordVisible = remember {
        mutableStateOf(false)
    }
    val visualTransformation = if (isPasswordVisible.value) {
        VisualTransformation.None
    } else {
        PasswordVisualTransformation()
    }

    var isNavigationDone by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.screen_background_color))
    ) {
        val viewModel = viewModel<LoginScreenViewModel>()
        val state = viewModel.state
        val context = LocalContext.current
        LaunchedEffect(key1 = context) {
            viewModel.validationEvents.collect { event ->
                when (event) {
                    is LoginScreenViewModel.ValidationEvent.Success -> {
                        viewModel.loginUser(context)
                    }
                }
            }
        }
        if (!state.isLoading && state.isSuccessLogin && !isNavigationDone) {
            if(userSingleton.personal){
                navController.navigate(LifitnessScreen.HomePersonal.name)
            }else{
                navController.navigate(LifitnessScreen.Home.name)
            }
            isNavigationDone = true
        }
        Box(
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                LogoComponent(60, 70)
                Spacer(modifier = Modifier.height(5.dp))

                NormalTextComposable(
                    text = stringResource(id = R.string.greeting_text),
                    fontSize = 15,
                    color = Color.White
                )
                NormalTextComposable(
                    text = stringResource(id = R.string.welcome_back_text),
                    fontSize = 25,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(5.dp))
                // Email Field
                OutlinedTextField(
                    value = state.email,
                    onValueChange = {
                        viewModel.onEvent(LoginFormEvent.EmailChanged(it))
                    },
                    isError = state.emailError != null,
                    modifier = Modifier
                        .background(Color(35, 33, 33), RoundedCornerShape(12.dp)),
                    label = {
                        Text(
                            text = stringResource(id = R.string.sign_up_email_field),
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
                        keyboardType = KeyboardType.Text
                    ),
                    textStyle = TextStyle(color = Color.White),
                    leadingIcon = {
                        Icon(
                            Icons.Default.Email,
                            contentDescription = "",
                            tint = Color.White
                        )
                    }
                )
                if (state.emailError != null) {
                    Text(
                        text = state.emailError,
                        color = MaterialTheme.colors.error,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
                //
                Spacer(modifier = Modifier.height(10.dp))
                //Password Field
                OutlinedTextField(
                    value = state.password,
                    onValueChange = {
                        viewModel.onEvent(LoginFormEvent.PasswordChanged(it))
                    },
                    isError = state.passwordError != null,
                    modifier = Modifier
                        .background(Color(35, 33, 33), RoundedCornerShape(12.dp)),
                    label = {
                        Text(
                            text = stringResource(id = R.string.sign_up_password_field),
                            color = Color.White
                        )
                    },
                    visualTransformation = visualTransformation,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    colors = OutlinedTextFieldDefaults.colors(
                        cursorColor = Color.White,
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        focusedLabelColor = Color.White,
                    ),
                    textStyle = TextStyle(color = Color.White),
                    leadingIcon = {
                        Icon(
                            Icons.Default.Lock,
                            contentDescription = "",
                            tint = Color.White
                        )
                    },
                    trailingIcon = {
                        val iconImage = if (isPasswordVisible.value) {
                            Icons.Default.Visibility
                        } else {
                            Icons.Default.VisibilityOff
                        }
                        IconButton(onClick = {
                            isPasswordVisible.value = !isPasswordVisible.value
                        }) {
                            Icon(
                                iconImage,
                                contentDescription = "",
                                tint = Color.White
                            )
                        }
                    }
                )
                if (state.passwordError != null) {
                    Text(
                        text = state.passwordError,
                        color = MaterialTheme.colors.error,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(horizontal = 65.dp),
                        textAlign = TextAlign.Center
                    )
                }
                //
                Spacer(modifier = Modifier.height(16.dp))
                ClickableForgotYouPasswordTextComponent(text = stringResource(id = R.string.forgot_your_password_text))
                Spacer(modifier = Modifier.height(190.dp))

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
                        text = stringResource(id = R.string.login_title),
                        textColor = Color.Black,
                        fontSize = 17,
                        minHeight = 30,
                        buttonColor = Color.White,
                        horizontalPadding = 50,
                        onClick = {
                            viewModel.onEvent(LoginFormEvent.Submit)
                        }
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    DividerTextComposable(
                        text = stringResource(id = R.string.divisive_text),
                        fontSize = 18,
                        color = Color.White,
                        thickness = 1
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(
                        modifier = Modifier.width(230.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        GoogleLoginButton(
                            25,
                            Color.White
                        ) {
                            if (user.personal) {

                            } else {
                                navController.navigate(LifitnessScreen.Home.name)
                            }
                        }
                        FacebookLoginButton(
                            size = 25,
                            buttonColor = Color.White
                        ) {
                            if (user.personal) {
                                navController.navigate(LifitnessScreen.HomePersonal.name)
                            } else {
                                navController.navigate(LifitnessScreen.Home.name)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    ClickableDontHaveAnAccountTextComponent(
                        text = stringResource(id = R.string.dont_hava_an_account_text),
                        onClick = {
                            navController.navigate(LifitnessScreen.Register.name)
                        }
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    if (state.isLoading) {
                        CircularProgressIndicator(
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewLoginScreen() {
    val navController = rememberNavController()
    LoginScreen(navController)
}