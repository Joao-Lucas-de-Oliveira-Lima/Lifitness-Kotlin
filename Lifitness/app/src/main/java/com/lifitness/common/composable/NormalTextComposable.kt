package com.lifitness.common.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NormalTextComposable(text: String, fontSize: Int, color: Color, horizontalPadding : Int = 0) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding.dp, vertical = 0.dp),
        style = TextStyle(
            fontSize = fontSize.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal
        ),
        color = color,
        textAlign = TextAlign.Center
    )
}

@Preview
@Composable
fun PreviewNormalTextComposable() {
    NormalTextComposable(text = "Preview", fontSize = 20, color = Color.White)
}
