package com.lifitness.singleton

import com.lifitness.repository.AuthRepository

class LoggedInUserSingleton {
    companion object {
        private var instance: LoggedInUserSingleton? = null

        fun getInstance(): LoggedInUserSingleton {
            if (instance == null) {
                instance = LoggedInUserSingleton()
            }
            return instance as LoggedInUserSingleton
        }
    }

    var myValue: String = "Hello from Singleton"
    var firebaseUid: String = ""
    var username: String = ""
    var email: String = ""

    fun updateUserInfo() {
        val authRepository = AuthRepository()
        firebaseUid = authRepository.getUserId()
    }
}