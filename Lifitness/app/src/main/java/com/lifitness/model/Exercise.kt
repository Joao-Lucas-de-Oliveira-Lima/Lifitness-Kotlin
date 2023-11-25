package com.lifitness.model

import kotlinx.serialization.Serializable

@Serializable
data class Exercise(
    val videoURL: String = "",
    val idTrain: Int = -1,
    val exerciseName: String = "",
    val exerciseDuration: String = "",
    val exerciseDescription: String = "",
)
