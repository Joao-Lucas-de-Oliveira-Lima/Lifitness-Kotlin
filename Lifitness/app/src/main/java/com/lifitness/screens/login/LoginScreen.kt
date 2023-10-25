package com.lifitness.screens.login

import ButtonWithoutIconComponent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.lifitness.R
import com.lifitness.common.composable.ClickableDontHaveAnAccountTextComponent
import com.lifitness.common.composable.ClickableForgotYouPasswordTextComponent
import com.lifitness.common.composable.DividerTextComponent
import com.lifitness.common.composable.LogoComponent
import com.lifitness.common.composable.NormalText
import com.lifitness.common.composable.PasswordTextFieldComponent
import com.lifitness.common.composable.TextFieldComponent

@Composable
fun LoginScreen() {
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
            Spacer(modifier = Modifier.height(20.dp))
            LogoComponent(60, 70)
            Spacer(modifier = Modifier.height(5.dp))
            NormalText(
                text = stringResource(id = R.string.greeting_text),
                fontSize = 15,
                color = Color.White
            )
            NormalText(
                text = stringResource(id = R.string.welcome_back_text),
                fontSize = 25,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(5.dp))
            TextFieldComponent(
                labelValue = stringResource(id = R.string.sign_up_username_field),
                imageVector = Icons.Default.Person
            )
            Spacer(modifier = Modifier.height(10.dp))
            PasswordTextFieldComponent(
                labelValue = stringResource(id = R.string.sign_up_password_field),
                imageVector = Icons.Default.Lock
            )
            Spacer(modifier = Modifier.height(10.dp))
            ClickableForgotYouPasswordTextComponent(text = stringResource(id = R.string.forgot_your_password_text))
            Spacer(modifier = Modifier.height(200.dp))
            ButtonWithoutIconComponent(
                text = stringResource(id = R.string.login_title),
                textColor = Color.Black,
                fontSize = 17,
                minHeight = 30,
                buttonColor = Color.White,
                horizontalPadding = 50
            )
            DividerTextComponent(
                text = "Or",
                fontSize = 18,
                color = Color.White,
                thickness = 1
            )
            ClickableDontHaveAnAccountTextComponent(text = stringResource(id = R.string.dont_hava_an_account_text))
        }
    }
}

@Preview
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
}