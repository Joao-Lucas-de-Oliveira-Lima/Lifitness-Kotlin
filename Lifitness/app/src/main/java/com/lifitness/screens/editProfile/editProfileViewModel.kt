package com.lifitness.screens.editProfile

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.lifitness.singleton.LoggedInUserSingleton
import kotlinx.coroutines.tasks.await


class EditProfileViewModel() : ViewModel() {
    val user = LoggedInUserSingleton.getInstance()
    private val db = FirebaseFirestore.getInstance()

    suspend fun updateUser(
        goal: String,
        height: String,
        weight: String,
        aLevel: String,
        wKeep: String,
        bio: String
    ) {
        try {
            user.weights.add(weight.toInt())
            val updates = hashMapOf(
                "height" to height,
                "weights" to user.weights,
                "bio" to bio,
                "goal" to goal,
                "activityLevel" to aLevel,
                "impediments" to wKeep
            )
            db.collection("users").document(user.username)
                .update(updates)
                .await()
        } catch (e: Exception) {
            print(e)
        }
        user.bio = bio
        user.goal = goal
        user.activityLevel = aLevel
        user.impediments = wKeep
        user.height = height.toInt()
    }
}