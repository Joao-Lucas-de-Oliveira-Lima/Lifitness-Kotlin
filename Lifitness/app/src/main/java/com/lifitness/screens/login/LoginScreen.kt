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
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
import com.lifitness.common.composable.PasswordTextFieldComposable
import com.lifitness.common.composable.TextFieldComposable

@Composable
fun LoginScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.screen_background_color))
    ) {
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
                TextFieldComposable(
                    labelValue = stringResource(id = R.string.sign_up_username_field),
                    hasAnIcon = true,
                    imageVector = Icons.Default.Person
                )
                Spacer(modifier = Modifier.height(10.dp))
                PasswordTextFieldComposable(
                    labelValue = stringResource(id = R.string.sign_up_password_field),
                    imageVector = Icons.Default.Lock
                )
                Spacer(modifier = Modifier.height(10.dp))
                ClickableForgotYouPasswordTextComponent(text = stringResource(id = R.string.forgot_your_password_text))
                Spacer(modifier = Modifier.height(10.dp))
                Spacer(modifier = Modifier.height(180.dp))

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
                            navController.navigate(LifitnessScreen.Home.name)
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
                        GoogleLoginButton(25, Color.White)
                        FacebookLoginButton(
                            size = 25,
                            buttonColor = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    ClickableDontHaveAnAccountTextComponent(
                        text = stringResource(id = R.string.dont_hava_an_account_text),
                        onClick = {
                            navController.navigate(LifitnessScreen.Register.name)
                        }
                    )
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