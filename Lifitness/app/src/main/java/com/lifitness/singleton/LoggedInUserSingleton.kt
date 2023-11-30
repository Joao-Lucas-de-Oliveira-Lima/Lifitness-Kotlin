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
    var firebaseAuthenticationUid: String = ""
    var username: String = ""
    var email: String = ""
    var age: Int = 0
    var height: Int = 0
    var weight: Int = 0

    fun updateUserInfo() {
        val authRepository = AuthRepository()
        firebaseAuthenticationUid = authRepository.getUserId()
    }
}