package com.lifitness.screens.trains

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.lifitness.model.Train

class TrainsViewModel(private val path: String) : ViewModel() {
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val exercisesCollection = firestore.collection(path)

    private val _trains = MutableLiveData<List<Train>>()
    val trains: LiveData<List<Train>> get() = _trains

    init {
        fetchExercises()
    }

    private fun fetchExercises() {
        exercisesCollection.get()
            .addOnSuccessListener { snapshot: QuerySnapshot ->
                val exercisesList = snapshot.toObjects(Train::class.java)
                _trains.value = exercisesList
            }
            .addOnFailureListener { exception ->
                // Handle error
            }
    }
}
