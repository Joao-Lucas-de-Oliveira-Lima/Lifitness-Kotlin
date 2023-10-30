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

