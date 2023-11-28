package com.lifitness.model

import kotlinx.serialization.Serializable

@Serializable
data class Train(
    val trainName: String = "",
    val duration: String = "",
    val trainId: Int = 0,
)
