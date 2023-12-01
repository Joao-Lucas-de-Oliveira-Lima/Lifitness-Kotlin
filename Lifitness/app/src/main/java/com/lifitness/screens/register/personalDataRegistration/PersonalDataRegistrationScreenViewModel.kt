package com.lifitness.screens.register.personalDataRegistration

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lifitness.domain.use_case.ValidateAge
import com.lifitness.domain.use_case.ValidateHeight
import com.lifitness.domain.use_case.ValidateWeight
import com.lifitness.repository.UserRepository
import com.lifitness.singleton.LoggedInUserSingleton
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class PersonalDataRegistrationScreenViewModel(
    private val validateAge: ValidateAge = ValidateAge(),
    private val validateHeight: ValidateHeight = ValidateHeight(),
    private val validateWeight: ValidateWeight = ValidateWeight()
) : ViewModel() {
    val userSingleton = LoggedInUserSingleton.getInstance()
    var state by mutableStateOf(PersonalDataRegistrationScreenFormState())
    val userRepository = UserRepository()

    private val validationEventChannel =
        Channel<PersonalDataRegistrationScreenViewModel.ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun onEvent(event: PersonalDataRegistrationScreenFormEvent) {
        when (event) {
            is PersonalDataRegistrationScreenFormEvent.AgeChanged -> {
                state = state.copy(age = event.age)
            }
            is PersonalDataRegistrationScreenFormEvent.HeightChanged -> {
                state = state.copy(height = event.height)
            }
            is PersonalDataRegistrationScreenFormEvent.WeightChanged -> {
                state = state.copy(weight = event.weight)
            }
            is PersonalDataRegistrationScreenFormEvent.NextScreen -> {
                nextScreen()
            }
        }
    }

    private fun nextScreen() {
        val ageResult = validateAge.execute(state.age)
        val heightResult = validateHeight.execute(state.height)
        val weightResult = validateWeight.execute(state.weight)

        val hasError = listOf(
            ageResult,
            heightResult,
            weightResult
        ).any { !it.successful }

        if (hasError) {
            state = state.copy(
                ageError = ageResult.errorMessage
            )
            state = state.copy(
                heightError = heightResult.errorMessage
            )
            state = state.copy(
                weightError = weightResult.errorMessage
            )
            return
        }
        viewModelScope.launch {
            userSingleton.age = state.age.toInt()
            userSingleton.weight = state.weight.toInt()
            userSingleton.height = state.height.toInt()
            //todo
            userRepository.saveUser()
            validationEventChannel.send(PersonalDataRegistrationScreenViewModel.ValidationEvent.Success)
        }
    }

    sealed class ValidationEvent {
        object Success : ValidationEvent()
    }

}