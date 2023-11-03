package com.lifitness.screens.progress

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lifitness.common.composable.*
import com.lifitness.common.ext.spacer
import com.lifitness.ui.theme.BackgroundColor

@Composable
fun ProgressScreen(){
    Column (Modifier.background(BackgroundColor)){
            ProgressTitle()
        Spacer(modifier = Modifier.spacer())
        Box(modifier = Modifier.padding(10.dp)) {
            WeightLineChart()
        }
        Spacer(modifier = Modifier.spacer())
        Box(modifier = Modifier.padding(10.dp)) {
            TableChartComposable()
        }
    }
}

@Preview
@Composable
fun PreviewProgressScreen(){
    ProgressScreen()
}
