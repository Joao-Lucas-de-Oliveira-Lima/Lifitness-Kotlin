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
    var weights: MutableList<Int> = mutableListOf()
    var bio: String = ""
    var personal: Boolean = false
    var goal: String = ""
    var activityLevel: String = ""
    var impediments: String = ""

    fun updateUserInfo() {
        val authRepository = AuthRepository()
        firebaseAuthenticationUid = authRepository.getUserId()
    }

    fun resetUserData(){
        var myValue: String = "Hello from Singleton"
        var firebaseAuthenticationUid: String = ""
        var username: String = ""
        var email: String = ""
        var age: Int = 0
        var height: Int = 0
        var weights: MutableList<Int> = mutableListOf()
        var bio: String = ""
        var personal: Boolean = false
        var goal: String = ""
        var activityLevel: String = ""
        var impediments: String = ""
    }
}