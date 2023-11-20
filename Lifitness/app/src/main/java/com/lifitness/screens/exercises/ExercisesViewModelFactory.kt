package com.lifitness.screens.exercises

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ExercisesViewModelFactory(private val path: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ExercisesViewModel::class.java)) {
            return ExercisesViewModel(path) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
