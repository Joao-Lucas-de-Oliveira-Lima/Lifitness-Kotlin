package com.lifitness.screens.profile

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lifitness.model.createSingleMock
import kotlinx.coroutines.launch

val user = createSingleMock()
class ProfileViewModel: ViewModel() {
    var photo by mutableStateOf<Uri?>(null)
    var isLoading by mutableStateOf(false)

    fun update(
        onSuccess: () -> Unit,
        onFailure: (String?) -> Unit
    ) {
        viewModelScope.launch {
            try {
                isLoading = true

                user.imageURL = photo

                onSuccess()
            } catch (e: Exception) {
                onFailure(e.message)
            }
            isLoading = false
        }
    }
}