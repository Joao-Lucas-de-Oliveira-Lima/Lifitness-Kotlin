package com.lifitness.model

import android.net.Uri

fun createMock(): List<Client>{
    val trains: List<Train> = listOf(
        Train("Chest", "60min", 1)
    )
    val imageURI = Uri.parse("https://via.placeholder.com/150")
    val clients: List<Client> = listOf(
        Client(
            imageURI, "nickname", "username", trains, false,
            "bio", "GOAL", 1.70, listOf(71.0, 70.0, 65.0, 72.0, 77.0), "Nothing", "Active"
        ),
    )
    return clients
}

fun createSingleMock(): Client{
    val trains: List<Train> = listOf(
        Train("Chest", "60min", 1)
    )
    val imageURI = Uri.parse("https://via.placeholder.com/150")
    val client = Client(
        imageURI, "nickname", "username", trains, false,
        "bio", "GOAL", 1.70, listOf(71.0, 70.0, 65.0, 72.0, 77.0), "Nothing", "Active"
        )
    return client
}

fun createPersonalMock(): Personal{
    val train: Train = Train("Chest", "60min", 1)
    val imageURI = Uri.parse("https://via.placeholder.com/150")
    val clients: List<Client> = listOf()
    val trains: List<Train> = listOf()
    val personal: Personal = Personal(
        imageURI, "Personal", "Teacher", trains, true, clients,
    )
    return personal
}