package com.lifitness.model

import kotlinx.serialization.Serializable
import java.net.URLDecoder
import java.net.URLEncoder


@Serializable
data class Exercise(
    var videoURL: String = "",
    val idTrain: List<Int> = listOf(),
    val exerciseName: String = "",
    val exerciseDuration: String = "",
    val exerciseDescription: String = "",
) {
    public fun encode () {
        videoURL = URLEncoder.encode(videoURL)
    }

    public fun decode () {
        videoURL = URLDecoder.decode(videoURL)
    }
}
