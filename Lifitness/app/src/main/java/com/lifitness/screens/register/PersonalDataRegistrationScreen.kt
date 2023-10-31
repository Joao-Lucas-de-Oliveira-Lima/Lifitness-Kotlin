package com.lifitness.screens.register

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lifitness.R
import com.lifitness.common.composable.ClickableLoginTextComponent
import com.lifitness.common.composable.DividerTextComposable
import com.lifitness.common.composable.NormalTextComposable
import com.lifitness.common.composable.RegistrationProgressBarComposable
import com.lifitness.common.composable.TextFieldWithoutIconComposable

@Composable
fun PersonalDataRegistrationScreen() {
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
                    onClick = { },
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
            TextFieldWithoutIconComposable(labelValue = stringResource(id = R.string.personal_data_registration_screen_age_field))
            Spacer(modifier = Modifier.height(10.dp))
            TextFieldWithoutIconComposable(labelValue = stringResource(id = R.string.personal_data_registration_screen_height_field))
            Spacer(modifier = Modifier.height(10.dp))
            TextFieldWithoutIconComposable(labelValue = stringResource(id = R.string.personal_data_registration_screen_weight_field))
            Spacer(modifier = Modifier.height(170.dp))
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
fun PreviewPersonalDataRegistrationScreen() {
    PersonalDataRegistrationScreen()
}