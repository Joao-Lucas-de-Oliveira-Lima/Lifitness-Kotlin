package com.lifitness.model

data class User (
    val imageURL: String,
    val nickname: String,
    val username: String,
    val bio: String,
    val goal: String,
    val height: Double,
    val weight: List<Double>,
    val whatKeep: String,
    val physicLevel: String,
    val trains: List<Train>,
    val personal: Boolean,
)