package com.lifitness.screens.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lifitness.domain.use_case.ValidateEmail
import com.lifitness.domain.use_case.ValidatePassword
import com.lifitness.domain.use_case.ValidateRepeatedPassword
import com.lifitness.domain.use_case.ValidateTerms
import com.lifitness.domain.use_case.ValidateUsername
import com.lifitness.repository.AuthRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class MainRegistrationScreenViewModel(
    private val repository: AuthRepository = AuthRepository(),
    private val validateUsername: ValidateUsername = ValidateUsername(),
    private val validateEmail: ValidateEmail = ValidateEmail(),
    private val validatePassword: ValidatePassword = ValidatePassword(),
    private val validateRepeatedPassword: ValidateRepeatedPassword = ValidateRepeatedPassword(),
    private val validateTerms: ValidateTerms = ValidateTerms()
) : ViewModel() {

    var state by mutableStateOf(MainRegistrationScreenFormState())

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun onEvent(event: MainRegistrationScreenFormEvent) {
        when (event) {
            is MainRegistrationScreenFormEvent.UsernameChanged -> {
                state = state.copy(username = event.username)
            }
            is MainRegistrationScreenFormEvent.EmailChanged -> {
                state = state.copy(email = event.email)
            }

            is MainRegistrationScreenFormEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
            }

            is MainRegistrationScreenFormEvent.RepeatedPasswordChanged -> {
                state = state.copy(repeatedPassword = event.repeatedPassword)
            }

            is MainRegistrationScreenFormEvent.AcceptTerms -> {
                state = state.copy(acceptedTerms = event.isAccepted)
            }

            is MainRegistrationScreenFormEvent.Submit -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        val usernameResult = validateUsername.execute(state.username)
        val emailResult = validateEmail.execute(state.email)
        val passwordResult = validatePassword.execute(state.password)
        val repeatedPasswordResult = validateRepeatedPassword.execute(
            state.password, state.repeatedPassword
        )
        val termsResult = validateTerms.execute(state.acceptedTerms)

        val hasError = listOf(
            usernameResult,
            emailResult,
            passwordResult,
            repeatedPasswordResult,
            termsResult
        ).any { !it.successful }

        if (hasError) {
            state = state.copy(
                usernameError = usernameResult.errorMessage,
                emailError = emailResult.errorMessage,
                passwordError = passwordResult.errorMessage,
                repeatedPasswordError = repeatedPasswordResult.errorMessage,
                termsError = termsResult.errorMessage,
            )
            return
        }
        viewModelScope.launch {
            validationEventChannel.send(ValidationEvent.Success)
        }
    }

    sealed class ValidationEvent {
        object Success : ValidationEvent()
    }
}