package com.lifitness.model

import kotlinx.serialization.Serializable

@Serializable
data class Food(
    val dietName: String = "",
    val dietId: Int = -1,
    val dietDescription: String = "",
    val dietNutricionalTable: List<String> = listOf("")
)
