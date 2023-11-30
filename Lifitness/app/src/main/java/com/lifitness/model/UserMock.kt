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
    val client = Client(
        "https://www.google.com/url?sa=i&url=https%3A%2F%2Fmicrobiology.ucr.edu%2Fimage%2Fprofile-image-placeholder&psig=AOvVaw2P-PtUvl3vxflO3voibZpe&ust=1701399575671000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCKCa_aXe6oIDFQAAAAAdAAAAABAE", "nickname", "username", trains, false,
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