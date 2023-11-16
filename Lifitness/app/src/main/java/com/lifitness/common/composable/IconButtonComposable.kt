package com.lifitness.common.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun IconButtonComposable(
    onClick: () -> Unit,
    imageVector: ImageVector,
    buttonColor: Color,
    size: Int
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .background(Color.Transparent), // Define o background como transparente

    ) {
        Icon(
            imageVector = imageVector, contentDescription = "", tint = buttonColor,
            modifier = Modifier
                .size(size.dp)
        )
    }
}