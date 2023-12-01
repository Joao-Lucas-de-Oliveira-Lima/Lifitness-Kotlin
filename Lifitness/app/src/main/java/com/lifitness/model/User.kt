package com.lifitness.model

import android.net.Uri
import android.text.BoringLayout

open class User (
    open var imageURL: String,
    open val nickname: String,
    open val username: String,
    open val personal: Boolean = false,
    open val trains: List<Train>,
)