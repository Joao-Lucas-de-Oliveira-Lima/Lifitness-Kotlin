package com.lifitness.screens.login

sealed class LoginFormEvent {
    data class UsernameChanged(val username: String): LoginFormEvent()
    data class PasswordChanged(val password: String): LoginFormEvent()
    object Submit: LoginFormEvent()
}