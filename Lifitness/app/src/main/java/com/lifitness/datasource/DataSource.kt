package com.lifitness.datasource

import com.google.firebase.firestore.FirebaseFirestore
import com.lifitness.singleton.LoggedInUserSingleton
import kotlinx.coroutines.tasks.await

class DataSource {
    private val db = FirebaseFirestore.getInstance()

    fun saveUser(
        firebaseAuthenticationUid: String,
        username: String,
        email: String,
        age: Int,
        height: Int,
        weight: Int
    ) {
        val userMap = hashMapOf(
            "firebaseAuthenticationUid" to firebaseAuthenticationUid,
            "username" to username,
            "email" to email,
            "age" to age,
            "height" to height,
            "weight" to weight
        )
        db.collection("users").document(username).set(userMap).addOnCompleteListener {

        }.addOnFailureListener {

        }
    }

    suspend fun getUserByUid(firebaseAuthenticationUid: String): Map<String, Any>? {
        try {
            val querySnapshot = db.collection("users")
                .whereEqualTo("firebaseAuthenticationUid", firebaseAuthenticationUid)
                .limit(1)
                .get()
                .await()

            if (!querySnapshot.isEmpty) {
                // Retorna o primeiro documento encontrado (limit(1))
                return querySnapshot.documents[0].data
            }
        } catch (e: Exception) {
            // Lidar com erros, se necessário
            // Por exemplo, log ou enviar uma mensagem de erro
        }

        return null
    }
}