package com.lifitness.model

import android.net.Uri

fun createMock(): List<Client>{
    val trains: List<Train> = listOf(
        Train("Chest", "60min", 1)
    )
    val clients: List<Client> = listOf(
        Client(
            "https://via.placeholder.com/150", "nickname", "username", trains, false,
            "bio", "GOAL", 1.70, listOf(71.0, 70.0, 65.0, 72.0, 77.0), "Nothing", "Active"
        ),
    )
    return clients
}

fun createSingleMock(): Client{
    val trains: List<Train> = listOf(
        Train("Chest", "60min", 1)
    )
    val client: Client = Client(
        "https://picsum.photos/800/800", "nickname", "username", trains, false,
        "bio", "GOAL", 1.70, listOf(71.0, 70.0, 65.0, 72.0, 77.0), "Nothing", "Active"
        )
    return client
}

fun createPersonalMock(): Personal{
    val train: Train = Train("Chest", "60min", 1)
    val clients: List<Client> = listOf()
    val trains: List<Train> = listOf()
    val personal: Personal = Personal(
        "https://via.placeholder.com/150", "Personal", "Teacher", trains, true, clients,
    )
    return personal
}