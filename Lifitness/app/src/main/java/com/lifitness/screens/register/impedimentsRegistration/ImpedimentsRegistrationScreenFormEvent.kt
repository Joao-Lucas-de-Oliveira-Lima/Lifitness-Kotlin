package com.lifitness.screens.register.impedimentsRegistration

import com.lifitness.screens.register.personalDataRegistration.PersonalDataRegistrationScreenFormEvent

sealed class ImpedimentsRegistrationScreenFormEvent {
    object Finishing: ImpedimentsRegistrationScreenFormEvent()
}