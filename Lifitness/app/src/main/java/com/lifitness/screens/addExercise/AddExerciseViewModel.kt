package com.lifitness.screens.addExercise

import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.lifitness.model.Exercise
import com.lifitness.model.Train
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.tasks.await


class AddExerciseViewModel: ViewModel() {
    val db = FirebaseFirestore.getInstance()
    val users = db.collection("user")
    val username = "Pedro Marcelo"
    val userDocumentRef = users.document(username)

//    suspend fun fetchExercises(exercise: Exercise, username: String, trainId: Int): List<Exercise>{
//        val trainCollection = users.document(username).collection("train").document(trainId)
//
//        val trainState = MutableStateFlow<List<Train>>(emptyList())
//
//        return if (document.exists()) {
//            val userData = document.data
//            val trains = userData?.get("trains") as? List<Train> ?: listOf()
//            trains
//        } else {
//            val trains = listOf<Train>()
//            trains
//        }
//    }

    fun getTrain(trains: List<Train>, train: Train){

    }
}