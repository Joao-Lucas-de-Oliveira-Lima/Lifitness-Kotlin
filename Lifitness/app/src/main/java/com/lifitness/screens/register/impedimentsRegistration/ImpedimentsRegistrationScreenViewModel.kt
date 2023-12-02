package com.lifitness.screens.register.impedimentsRegistration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lifitness.repository.UserRepository
import com.lifitness.screens.register.personalDataRegistration.PersonalDataRegistrationScreenFormEvent
import com.lifitness.screens.register.personalDataRegistration.PersonalDataRegistrationScreenViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class ImpedimentsRegistrationScreenViewModel(): ViewModel() {
    val userRepository = UserRepository()

    private val validationEventChannel =
        Channel<ImpedimentsRegistrationScreenViewModel.ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()


    fun onEvent(event: ImpedimentsRegistrationScreenFormEvent) {
        when (event) {
            is ImpedimentsRegistrationScreenFormEvent.Finishing -> {
                finishing()
            }
        }
    }

    private fun finishing() {
        viewModelScope.launch {
            userRepository.saveUser()
            validationEventChannel.send(ImpedimentsRegistrationScreenViewModel.ValidationEvent.Success)
        }
    }

    sealed class ValidationEvent {
        object Success : ValidationEvent()
    }

}

