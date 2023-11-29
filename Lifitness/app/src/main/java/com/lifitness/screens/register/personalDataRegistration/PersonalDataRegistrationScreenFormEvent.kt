package com.lifitness.screens.register.personalDataRegistration

import com.lifitness.screens.register.MainRegistrationScreenFormEvent

sealed class PersonalDataRegistrationScreenFormEvent{
    data class AgeChanged(val age: String) : PersonalDataRegistrationScreenFormEvent()
    data class HeightChanged(val height: String) : PersonalDataRegistrationScreenFormEvent()
    data class WeightChanged(val weight: String) : PersonalDataRegistrationScreenFormEvent()

    object NextScreen: PersonalDataRegistrationScreenFormEvent()
}
