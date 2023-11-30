package com.lifitness.screens.addTrain

import com.google.firebase.firestore.FirebaseFirestore
import com.lifitness.model.Train
import kotlinx.coroutines.tasks.await

class AddTrainViewModel {

    val db = FirebaseFirestore.getInstance()
    val users = db.collection("user")
    val username = "Pedro Marcelo"
    val userDocumentRef = users.document(username)

    suspend fun fetchTrains(train: Train, username: String): List<Train>{
        val userDocumentRef = users.document(username)
        val document = userDocumentRef.get().await()
        return if (document.exists()) {
            val userData = document.data
            val trains = userData?.get("trains") as? List<Train> ?: listOf()
            trains
        } else {
            val trains = listOf<Train>()
            trains
        }
    }
}