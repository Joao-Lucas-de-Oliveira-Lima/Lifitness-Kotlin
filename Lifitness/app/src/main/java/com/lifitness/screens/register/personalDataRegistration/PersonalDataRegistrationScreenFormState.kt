package com.lifitness.screens.register.personalDataRegistration

data class PersonalDataRegistrationScreenFormState(
    val age : String = "",
    val ageError: String? = null,
    val height: String = "",
    val heightError: String? = null,
    val weight: String = "",
    val weightError: String? = null,
)
