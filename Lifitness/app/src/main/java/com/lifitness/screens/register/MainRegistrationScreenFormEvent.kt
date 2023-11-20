package com.lifitness.screens.register

sealed class MainRegistrationScreenFormEvent {
    data class UsernameChanged(val username: String) : MainRegistrationScreenFormEvent()
    data class EmailChanged(val email: String) : MainRegistrationScreenFormEvent()
    data class PasswordChanged(val password: String) : MainRegistrationScreenFormEvent()
    data class RepeatedPasswordChanged(
        val repeatedPassword: String
    ) : MainRegistrationScreenFormEvent()

    data class AcceptTerms(val isAccepted: Boolean) : MainRegistrationScreenFormEvent()

    object Submit: MainRegistrationScreenFormEvent()
}