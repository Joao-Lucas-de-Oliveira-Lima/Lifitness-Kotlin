package com.lifitness.screens.register.personalDataRegistration

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lifitness.domain.use_case.ValidateAge
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class PersonalDataRegistrationScreenViewModel(
    private val validateAge: ValidateAge = ValidateAge()
) : ViewModel() {

    var state by mutableStateOf(PersonalDataRegistrationScreenFormState())

    private val validationEventChannel =
        Channel<PersonalDataRegistrationScreenViewModel.ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun onEvent(event: PersonalDataRegistrationScreenFormEvent) {
        when (event) {
            is PersonalDataRegistrationScreenFormEvent.AgeChanged -> {
                state = state.copy(age = event.age)
            }

            is PersonalDataRegistrationScreenFormEvent.NextScreen -> {
                nextScreen()
            }

            else -> {}
        }
    }

    private fun nextScreen() {
        val ageResult = validateAge.execute(state.age)

        val hasError = listOf(
            ageResult
        ).any { !it.successful }

        if (hasError) {
            state = state.copy(
                ageError = ageResult.errorMessage
            )
            return
        }
        viewModelScope.launch {
            validationEventChannel.send(PersonalDataRegistrationScreenViewModel.ValidationEvent.Success)
        }
    }

    sealed class ValidationEvent {
        object Success : ValidationEvent()
    }

}