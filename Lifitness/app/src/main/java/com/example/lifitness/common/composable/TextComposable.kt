package com.example.lifitness.common.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.lifitness.R.string as AppText

@Composable
fun MoreTitle(){
    Text(stringResource(AppText.more_title))
}