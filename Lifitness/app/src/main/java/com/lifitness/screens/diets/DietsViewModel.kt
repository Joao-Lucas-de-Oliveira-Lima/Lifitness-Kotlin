package com.lifitness.screens.diets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

class DietsViewModel(): ViewModel() {
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val dietsCollection = firestore.collection("diets")

    private val _diets = MutableLiveData<List<Diet>>()
    val diets: LiveData<List<Diet>> get() = _diets

    init {
        fetchDiets()
    }

    private fun fetchDiets() {
        dietsCollection.get()
            .addOnSuccessListener { snapshot: QuerySnapshot ->
                val dietList = snapshot.toObjects(Diet::class.java)
                _diets.value = dietList
            }
            .addOnFailureListener { exception ->
                // Handle error
            }
    }
}