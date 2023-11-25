package com.lifitness.screens.diets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.lifitness.model.Food

class DietsViewModel(): ViewModel() {
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val dietsCollection = firestore.collection("diets")

    private val _diets = MutableLiveData<List<Food>>()
    val diets: LiveData<List<Food>> get() = _diets

    init {
        fetchDiets()
    }

    private fun fetchDiets() {
        dietsCollection.get()
            .addOnSuccessListener { snapshot: QuerySnapshot ->
                val dietList = snapshot.toObjects(Food::class.java)
                _diets.value = dietList
            }
            .addOnFailureListener { exception ->
                // Handle error
            }
    }
}