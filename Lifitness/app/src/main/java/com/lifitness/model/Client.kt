package com.lifitness.model

import android.net.Uri

open class Client(
    override var imageURL: String,
    override val nickname: String,
    override val username: String,
    override val trains: List<Train>,
    override val personal: Boolean = false,
    val bio: String,
    val goal: String,
    val height: Double,
    val weight: List<Double>,
    val whatKeep: String,
    val physicLevel: String,
): User(
   imageURL,
    nickname,
    username,
    personal,
    trains
)