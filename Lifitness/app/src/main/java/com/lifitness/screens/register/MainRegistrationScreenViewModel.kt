package com.lifitness.screens.register

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.lifitness.domain.use_case.ValidateEmail
import com.lifitness.domain.use_case.ValidatePassword
import com.lifitness.domain.use_case.ValidateRepeatedPassword
import com.lifitness.domain.use_case.ValidateTerms
import com.lifitness.domain.use_case.ValidateUsername
import com.lifitness.repository.AuthRepository
import com.lifitness.repository.UserRepository
import com.lifitness.singleton.LoggedInUserSingleton
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

    val userSingleton = LoggedInUserSingleton.getInstance()
    val userRepository = UserRepository()

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

    //Testing
    fun createUser(context: Context) = viewModelScope.launch {
        val userSingleton = LoggedInUserSingleton.getInstance()
        try {
            state = state.copy(isLoading = true)
            repository.createUser(
                state.email,
                state.password
            ) { isSuccessful ->
                if (isSuccessful) {
                    //todo
                    userSingleton.email = state.email
                    userSingleton.username = state.username
                    state = state.copy(isSuccessLogin = true)
                } else {
                    state = state.copy(isSuccessLogin = false)
                }

            }
        } catch (e: Exception) {
            //loginUiState = loginUiState.copy(signUpError = e.localizedMessage)
            //e.printStackTrace()
        } finally {
            state = state.copy(isLoading = false)
        }
    }

    sealed class ValidationEvent {
        object Success : ValidationEvent()
    }

    fun authenticateGoogleWithFirebase(context: Context, token: String) {
        val auth = Firebase.auth
        try {
            state = state.copy(isLoading = true)
            Toast.makeText(
                context, "success Login", Toast.LENGTH_SHORT
            ).show()
            val credential = GoogleAuthProvider.getCredential(token, null)
            auth.signInWithCredential(credential)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        viewModelScope.launch {
                            state = state.copy(isSuccessLogin = true)
                            // User is signed in with Firebase successfully
                            val firebaseUser = auth.currentUser
                            if (firebaseUser != null) {
                                userSingleton.firebaseAuthenticationUid = firebaseUser.uid
                                val userData = userRepository.getUserByUid()
                                if (userData != null) {
                                    //todo
                                    userSingleton.username = userData["username"].toString()
                                    userSingleton.email = userData["email"].toString()
                                    userSingleton.age = userData["age"].toString().toInt()
                                    userSingleton.height = userData["height"].toString().toInt()
                                    userSingleton.personal =
                                        userData["personal"].toString().toBoolean()
                                    userSingleton.impediments = userData["impediments"].toString()
                                    userSingleton.activityLevel =
                                        userData["activityLevel"].toString()
                                    userSingleton.goal = userData["goal"].toString()
                                    userSingleton.bio = userData["bio"].toString();
                                    val weightsArray = userData["weights"] as? MutableList<Int>
                                    weightsArray?.let { userSingleton.weights.addAll(it) }
                                }
                            }
                            Log.d(
                                "Firebase",
                                "Firebase Authentication Successful: ${firebaseUser?.uid}"
                            )
                        }
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("Firebase", "Firebase Authentication Failed", task.exception)
                    }
                }
        } catch (e: Exception) {

        } finally {
            state = state.copy(isLoading = false)
        }
    }
}