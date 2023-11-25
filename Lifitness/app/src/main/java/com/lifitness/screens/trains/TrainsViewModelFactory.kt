package com.lifitness.screens.trains

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TrainsViewModelFactory(private val path: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TrainsViewModel::class.java)) {
            return TrainsViewModel(path) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
