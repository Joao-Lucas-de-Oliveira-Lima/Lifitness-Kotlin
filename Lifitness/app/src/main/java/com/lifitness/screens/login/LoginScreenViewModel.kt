package com.lifitness.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.lifitness.domain.use_case.ValidateEmail

class LoginScreenViewModel(

):ViewModel() {

    var state by mutableStateOf(LoginFormState())

}