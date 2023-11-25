package com.lifitness.screens.editProfile

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

fun changeGoal(){
    val db = Firebase.firestore
    db.collection("user")
        .get()
        .addOnSuccessListener { result ->
            for (document in result) {

            }
        }
}

fun changeBio(){
    val db = Firebase.firestore
    db.collection("user")
        .get()
        .addOnSuccessListener { result ->
            for (document in result) {

            }
        }
}

fun changeWeight(){
    val db = Firebase.firestore
    db.collection("user")
        .get()
        .addOnSuccessListener { result ->
            for (document in result) {

            }
        }
}

fun changeHeight(){
    val db = Firebase.firestore
    db.collection("user")
        .get()
        .addOnSuccessListener { result ->
            for (document in result) {

            }
        }
}

fun changeActivityLevel(){
    val db = Firebase.firestore
    db.collection("user")
        .get()
        .addOnSuccessListener { result ->
            for (document in result) {

            }
        }
}

fun changeProblems(){
    val db = Firebase.firestore
    db.collection("user")
        .get()
        .addOnSuccessListener { result ->
            for (document in result) {

            }
        }
}