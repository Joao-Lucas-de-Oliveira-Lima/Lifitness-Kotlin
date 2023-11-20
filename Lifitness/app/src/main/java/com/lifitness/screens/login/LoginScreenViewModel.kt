package com.lifitness.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginScreenViewModel:ViewModel() {

    var state by mutableStateOf(LoginFormState())

}