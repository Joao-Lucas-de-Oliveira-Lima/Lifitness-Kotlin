package com.lifitness.screens.login

data class LoginFormState(
    val username : String = "",
    val usernameError : String? = null,
    val password : String = "",
    val passwordError : String? = null
)
