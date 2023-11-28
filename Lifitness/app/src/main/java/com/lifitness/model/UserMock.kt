package com.lifitness.model

fun createMock(): List<User>{
    val train: Train = Train("Chest", "60min", 1)
    val users: List<User> = listOf(
        User(
            "URL", "nickname", "username", "bio", "goal",
            1.70, listOf(71.0), "Nothing", "Active", listOf(train), false),
    )
    return users
}

fun createSingleMock(): User{
    val train: Train = Train("Chest", "60min", 1)
    val user: User = User(
        "URL", "nickname", "username", "bio", "goal",
        1.70, listOf(71.0, 70.0, 65.0, 72.0, 77.0), "Nothing", "Active", listOf(train), false
        )
    return user
}

fun createPersonalMock(): User{
    val train: Train = Train("Chest", "60min", 1)
    val user: User = User(
        "URL", "nickname", "username", "bio", "goal",
        1.70, listOf(71.0, 70.0, 65.0, 72.0, 77.0), "Nothing", "Active", listOf(train), true
    )
    return user
}