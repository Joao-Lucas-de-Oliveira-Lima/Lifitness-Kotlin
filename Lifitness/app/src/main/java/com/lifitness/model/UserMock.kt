package com.lifitness.model

fun createMock(): List<User>{
    val users: List<User> = listOf(
        User("test", "test", "test", "test"),
        User("test", "test", "test", "test"),
        User("test", "test", "test", "test"),
    )
    return users
}