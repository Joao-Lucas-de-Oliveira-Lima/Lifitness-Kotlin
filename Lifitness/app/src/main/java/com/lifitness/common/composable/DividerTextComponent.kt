package com.lifitness.common.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DividerTextComponent(text: String, fontSize: Int, color: Color, thickness: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F),
            color = color,
            thickness = thickness.dp
        )
        Text(
            text = text,
            fontSize = fontSize.sp,
            color = color
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F),
            color = color,
            thickness = thickness.dp
        )
    }
}