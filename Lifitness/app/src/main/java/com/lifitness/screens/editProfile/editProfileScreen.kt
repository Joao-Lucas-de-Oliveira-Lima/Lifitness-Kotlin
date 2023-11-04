package com.lifitness.screens.editProfile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lifitness.common.composable.EditTitle
import com.lifitness.common.composable.SmallButton
import com.lifitness.common.composable.TextFieldComponent
import com.lifitness.common.ext.spacer
import com.lifitness.ui.theme.ButtonEdit


@Composable
fun EditProfileScreen() {

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()) {
        EditTitle()
        Spacer(modifier = Modifier.spacer())
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.spacer())
            TextFieldComponent(labelValue = "Goal")
            Spacer(modifier = Modifier.spacer())
            TextFieldComponent(labelValue = "Weight (Kg)")
            Spacer(modifier = Modifier.spacer())
            TextFieldComponent(labelValue = "Height (CM)")
            Spacer(modifier = Modifier.spacer())
            TextFieldComponent(labelValue = "Level of physical activity")
            Spacer(modifier = Modifier.spacer())
            TextFieldComponent(labelValue = "What keep you from working-out")
            Spacer(modifier = Modifier.spacer())
            TextFieldComponent(labelValue = "Bio")
            Spacer(modifier = Modifier.spacer())
            SmallButton(
                contentTitle = "SALVAR",
                onClick = { /*TODO*/ },
                buttonColor = ButtonEdit
            )
        }

    }
}

@Preview
@Composable
fun PreviewEdit(){
    EditProfileScreen()
}
