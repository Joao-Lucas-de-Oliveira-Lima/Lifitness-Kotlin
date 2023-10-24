package com.lifitness.common.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lifitness.R
import com.lifitness.ui.theme.TextColor
import com.lifitness.R.string as AppText

@Composable
fun MoreTitle() {
    Text(
        stringResource(AppText.more_title),
        color = TextColor,
        fontFamily = FontFamily.SansSerif,
        fontSize = 24.sp,
        modifier = Modifier
            .padding(start = 20.dp)
            .padding(top = 20.dp),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun SettingsTitle() {
    Text(
        stringResource(AppText.settings_title),
        color = TextColor,
        fontFamily = FontFamily.SansSerif,
        fontSize = 24.sp,
        modifier = Modifier
            .padding(start = 20.dp)
            .padding(top = 20.dp),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun GreetingText(text: String = stringResource(id = R.string.greeting_text)) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth(),
        style = TextStyle(
            fontSize = 15.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal
        ),
        color = Color.White,
        textAlign = TextAlign.Center
    )
}

@Composable
fun CreateAnAccountText(text: String = stringResource(id = R.string.create_an_account_text)) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth(),
        style = TextStyle(
            fontSize = 25.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold
        ),
        color = Color.White,
        textAlign = TextAlign.Center
    )
}

@Composable
fun BrandLogoNameTitle(
    value: String = stringResource(id = R.string.brand_logo_name),
    minHeight: Int
) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            //Altura mínima
            .heightIn(min = minHeight.dp),
        style = TextStyle(
            fontSize = 50.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal
        ),
        color = Color.White,
        textAlign = TextAlign.Center
    )
}

@Preview
@Composable
fun PreviewBrandLogoNameComponent() {
    BrandLogoNameTitle(minHeight = 80)
}