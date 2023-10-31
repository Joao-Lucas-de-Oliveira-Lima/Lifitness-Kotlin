package com.lifitness.common.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RegistrationProgressBarComposable(
    currentStep: Int,
    totalSteps: Int,
    barColor: Color,
    width: Int
) {
    val progress = (currentStep / totalSteps.toFloat())
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier.width(width.dp),
                color = barColor
            )
            /*
            Text(
                text = "Passo $currentStep de $totalSteps",
                style = TextStyle(color = Color.Black),
                modifier = Modifier.padding(8.dp)
            )
             */
        }
    }
}