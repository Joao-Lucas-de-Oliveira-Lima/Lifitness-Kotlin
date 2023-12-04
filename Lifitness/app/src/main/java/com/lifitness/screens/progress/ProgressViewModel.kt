package com.lifitness.screens.progress

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.lifitness.model.Exercise
import com.lifitness.singleton.LoggedInUserSingleton

class ProgressViewModel(): ViewModel() {

    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val exercisesCollection = firestore.collection("/exercise")
    val user = LoggedInUserSingleton.getInstance()
    private val _exercises = MutableLiveData<List<Exercise>>()
    val exercises: LiveData<List<Exercise>> get() = _exercises

    fun getExercise(): LiveData<List<Exercise>>{
        return exercises
    }
}
