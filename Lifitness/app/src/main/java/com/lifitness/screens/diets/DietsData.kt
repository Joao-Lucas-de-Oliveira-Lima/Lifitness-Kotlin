package com.lifitness.screens.diets

import kotlinx.serialization.Serializable

@Serializable
data class Diet(
    val dietName: String = "",
    val dietId: Int = -1,
    val dietDescription: String = "",
    val dietNutricionalTable: List<String> = listOf("")
)