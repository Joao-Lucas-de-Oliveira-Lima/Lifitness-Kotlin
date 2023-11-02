package com.lifitness.screens.register

import ButtonWithoutIconComposable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
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
import com.lifitness.common.composable.CheckboxComposable
import com.lifitness.common.composable.ClickableLoginTextComponent
import com.lifitness.common.composable.DividerTextComposable
import com.lifitness.common.composable.LogoComponent
import com.lifitness.common.composable.NormalTextComposable
import com.lifitness.common.composable.PasswordTextFieldComposable
import com.lifitness.common.composable.RegistrationProgressBarComposable
import com.lifitness.common.composable.TextFieldComposable

@Composable
fun MainRegistrationScreen() {
    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.screen_background_color))
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxSize(),
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            RegistrationProgressBarComposable(
                currentStep = 1,
                totalSteps = 5,
                Color(255, 102, 102),
                160
            )
            Spacer(modifier = Modifier.height(5.dp))
            LogoComponent(60, 70)
            Spacer(modifier = Modifier.height(5.dp))
            NormalTextComposable(
                text = stringResource(id = R.string.greeting_text),
                fontSize = 15,
                color = Color.White,
            )
            NormalTextComposable(
                text = stringResource(id = R.string.create_an_account_text),
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
            TextFieldComposable(
                labelValue = stringResource(id = R.string.sign_up_email_field),
                hasAnIcon = true,
                imageVector = Icons.Default.Email
            )
            Spacer(modifier = Modifier.height(10.dp))
            PasswordTextFieldComposable(
                labelValue = stringResource(id = R.string.sign_up_password_field),
                imageVector = Icons.Default.Lock
            )
            Spacer(modifier = Modifier.height(10.dp))
            PasswordTextFieldComposable(
                labelValue = stringResource(id = R.string.sign_up_retype_your_password_field),
                imageVector = Icons.Default.Lock
            )
            Spacer(modifier = Modifier.height(5.dp))
            CheckboxComposable(text = stringResource(id = R.string.privacy_policy_and_terms_of_use_text))
            Spacer(modifier = Modifier.height(50.dp))
            ButtonWithoutIconComposable(
                text = stringResource(id = R.string.next_title),
                textColor = Color.Black,
                fontSize = 17,
                minHeight = 30,
                buttonColor = Color.White,
                horizontalPadding = 50
            )
            Spacer(modifier = Modifier.height(5.dp))
            DividerTextComposable(
                text = stringResource(id = R.string.divisive_text),
                fontSize = 18,
                color = Color.White,
                thickness = 1
            )
            ClickableLoginTextComponent(text = stringResource(id = R.string.create_an_account_text))
            Spacer(modifier = Modifier.height(5.dp))

        }
    }
}

@Preview
@Composable
fun PreviewMainRegistrationScreen() {
    MainRegistrationScreen()
}