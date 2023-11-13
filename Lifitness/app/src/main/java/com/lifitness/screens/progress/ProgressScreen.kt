package com.lifitness.screens.progress

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.unit.sp
import com.lifitness.common.composable.*
import com.lifitness.common.ext.endOfScreenSpacer
import com.lifitness.common.ext.smallSpacer
import com.lifitness.common.ext.spacer
import com.lifitness.ui.theme.BackgroundColor
import com.lifitness.ui.theme.TextColor

@Composable

fun ProgressScreen(navController: NavHostController){
    Column (
        Modifier
            .background(BackgroundColor)
            .fillMaxHeight()
    ){
        ProgressTitle()
        Spacer(modifier = Modifier.spacer())
        Text(
            text = "Gráfico de peso",
            color = TextColor,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.smallSpacer())
        Box(modifier = Modifier.padding(10.dp)) {
            WeightLineChart()
        }
        Spacer(modifier = Modifier.spacer())
        Text(
            text = "Tabela de treinos",
            color = TextColor,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.smallSpacer())
        Box(modifier = Modifier.padding(10.dp)) {
            TableChartComposable()
        }
        Spacer(modifier = Modifier.endOfScreenSpacer())
    }
}

@Preview
@Composable
fun PreviewProgressScreen(){
    val navController = rememberNavController()
    ProgressScreen(navController)
}
