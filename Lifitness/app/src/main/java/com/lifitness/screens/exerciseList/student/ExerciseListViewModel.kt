package com.lifitness.screens.exerciseList.student

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.lifitness.model.Exercise


class ExerciseListViewModel() : ViewModel() {
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val exercisesCollection = firestore.collection("/exercise")

    private val _exercises = MutableLiveData<List<Exercise>>()
    val exercises: LiveData<List<Exercise>> get() = _exercises

    fun fetchExercisesForTrain(idTrain: Int) {
        exercisesCollection
            .whereEqualTo("idTrain", idTrain)
            .get()
            .addOnSuccessListener { snapshot: QuerySnapshot ->
                val exercisesList = snapshot.toObjects(Exercise::class.java)
                _exercises.value = exercisesList
            }
            .addOnFailureListener { exception ->
                // Handle error
            }
    }
}