package com.lifitness.model

fun createMock(): List<User>{
    val users: List<User> = listOf(
        User(
            "URL", "nickname", "username", "bio", "goal",
            1.70, 71.0, "Nothing", "Active"),
    )
    return users
}

fun createSingleMock(): User{
    val user: User = User(
        "URL", "nickname", "username", "bio", "goal",
        1.70, 71.0, "Nothing", "Active"
        )
    return user
}