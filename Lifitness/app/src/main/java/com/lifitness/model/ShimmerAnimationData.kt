package com.lifitness.model

import androidx.compose.ui.graphics.Color

data class ShimmerAnimationData(val color: Color) {
    fun getColours(): List<Color> {
        return listOf(
            color.copy(alpha = 0.0f),
            color.copy(alpha = 0.3f),
            color.copy(alpha = 0.5f),
            color.copy(alpha = 0.3f),
            color.copy(alpha = 0.0f),
        )
    }
}