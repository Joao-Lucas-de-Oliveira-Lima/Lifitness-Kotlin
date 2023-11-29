package com.lifitness.screens.register

data class MainRegistrationScreenFormState(
    val username : String = "",
    val usernameError: String? = null,
    val email: String = "",
    val emailError: String? = null,
    val password: String = "",
    val passwordError: String? = null,
    val repeatedPassword: String = "",
    val repeatedPasswordError: String? = null,
    val acceptedTerms: Boolean = false,
    val termsError: String? = null,
    val isLoading: Boolean = false,
    val isSuccessLogin: Boolean = false
)
