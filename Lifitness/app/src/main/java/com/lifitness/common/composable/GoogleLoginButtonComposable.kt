package com.lifitness.common.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lifitness.R

@Composable
fun GoogleLoginButton(size: Int, buttonColor : Color, onClick : () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
            //.size(size.dp)
            .padding(0.dp),
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(buttonColor)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_google_logo),
            contentDescription = null,
            modifier = Modifier.size(size.dp)
        )
    }
}


@Composable
@Preview
fun PreviewGoogleLoginButton() {
    GoogleLoginButton(80, Color.White) {};
}