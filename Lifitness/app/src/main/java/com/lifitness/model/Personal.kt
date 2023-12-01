package com.lifitness.model

import android.net.Uri

open class Personal(
    override var imageURL: String,
    override val nickname: String,
    override val username: String,
    override val trains: List<Train>,
    override val personal: Boolean = false,
    val clients: List<Client>,
): User(
    imageURL,
    nickname,
    username,
    personal,
    trains,
)