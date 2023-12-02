package com.lifitness.screens.profile

import androidx.lifecycle.ViewModel
import com.lifitness.singleton.LoggedInUserSingleton

class ProfileViewModel : ViewModel() {
    val user = LoggedInUserSingleton

    fun getUserInfo(): LoggedInUserSingleton.Companion {
        return user
    }
}