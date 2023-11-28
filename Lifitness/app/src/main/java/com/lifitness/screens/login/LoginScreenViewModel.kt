package com.lifitness.screens.login

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lifitness.domain.use_case.ValidateEmail
import com.lifitness.domain.use_case.ValidatePassword
import com.lifitness.repository.AuthRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class LoginScreenViewModel(
    private val validateEmail: ValidateEmail = ValidateEmail(),
    private val validatePassword: ValidatePassword = ValidatePassword(),
    private val repository: AuthRepository = AuthRepository()
) : ViewModel() {

    val currentUser = repository.currentUser

    val hasUser: Boolean
        get() = repository.hasUser()

    var state by mutableStateOf(LoginFormState())

    private val validationEventChannel = Channel<ValidationEvent> { }
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun onEvent(event: LoginFormEvent) {
        when (event) {
            is LoginFormEvent.EmailChanged -> {
                state = state.copy(email = event.email)
            }

            is LoginFormEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
            }

            is LoginFormEvent.Submit -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        val usernameResult = validateEmail.execute(state.email)
        val passwordResult = validatePassword.execute(state.password)

        val hasError = listOf(
            usernameResult, passwordResult
        ).any { !it.successful }

        if (hasError) {
            state = state.copy(
                emailError = usernameResult.errorMessage,
                passwordError = passwordResult.errorMessage
            )
            return
        }
        viewModelScope.launch {
            validationEventChannel.send(ValidationEvent.Success)
        }
    }

    //Testing

    fun loginUser(context: Context) = viewModelScope.launch {
        try {
            repository.loginUser(
                state.email, state.password
            ) { isSuccessful ->
                if (isSuccessful) {
                    Toast.makeText(
                        context, "success Login", Toast.LENGTH_SHORT
                    ).show()
                    state = state.copy(isSuccessLogin = true)
                } else {
                    Toast.makeText(
                        context, "Failed Login", Toast.LENGTH_SHORT
                    ).show()
                    state = state.copy(isSuccessLogin = false)
                }
            }

        } catch (e: Exception) {
            //loginUiState = loginUiState.copy(loginError = e.localizedMessage)
            //e.printStackTrace()
        } finally {
            state = state.copy(isLoading = false)
        }
    }

    sealed class ValidationEvent {
        object Success : ValidationEvent()
    }

}