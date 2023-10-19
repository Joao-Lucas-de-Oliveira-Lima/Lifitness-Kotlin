package com.lifitness.common.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lifitness.R.string as AppText
import com.lifitness.ui.theme.TextColor

@Composable
fun MoreTitle(){
    Text(stringResource(AppText.more_title),
        color = TextColor,
        fontFamily = FontFamily.SansSerif,
        fontSize = 24.sp,
        modifier = Modifier.padding(start = 20.dp).padding(top = 20.dp),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun EditTitle(){
    Text(stringResource(AppText.edit_title),
        color = TextColor,
        fontFamily = FontFamily.SansSerif,
        fontSize = 24.sp,
        modifier = Modifier.padding(start = 20.dp).padding(top = 20.dp),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun SettingsTitle(){
    Text(stringResource(AppText.settings_title),
        color = TextColor,
        fontFamily = FontFamily.SansSerif,
        fontSize = 24.sp,
        modifier = Modifier.padding(start = 20.dp).padding(top = 20.dp),
        fontWeight = FontWeight.Bold
    )
}