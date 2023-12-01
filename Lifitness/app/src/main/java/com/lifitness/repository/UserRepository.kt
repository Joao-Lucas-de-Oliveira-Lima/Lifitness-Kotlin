package com.lifitness.repository

import com.lifitness.datasource.DataSource
import com.lifitness.singleton.LoggedInUserSingleton

class UserRepository() {
    private val dataSource = DataSource()
    private val userSingleton = LoggedInUserSingleton.getInstance()
    fun saveUser(){
        dataSource.saveUser(
            userSingleton.firebaseAuthenticationUid,
            userSingleton.username,
            userSingleton.email,
            userSingleton.age,
            userSingleton.height,
            userSingleton.weight,
            userSingleton.personal,
            userSingleton.bio,
            userSingleton.goal,
            userSingleton.activityLevel,
            userSingleton.impediments
        );
    }

    suspend fun getUserByUid(): Map<String, Any>?{
        return dataSource.getUserByUid(userSingleton.firebaseAuthenticationUid)
    }

    suspend fun getUserByUsername(username: String): Map<String, Any>?{
        return dataSource.getUserByUsername(username)
    }
}