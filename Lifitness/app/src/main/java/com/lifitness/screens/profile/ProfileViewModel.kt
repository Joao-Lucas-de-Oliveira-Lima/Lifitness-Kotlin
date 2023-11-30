package com.lifitness.screens.profile

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.Painter
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.compose.rememberImagePainter
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.lifitness.model.createSingleMock
import kotlinx.coroutines.launch
import com.google.firebase.storage.storage
import com.lifitness.singleton.LoggedInUserSingleton

class ProfileViewModel: ViewModel() {
    val user = LoggedInUserSingleton

    fun getUserInfo() : LoggedInUserSingleton.Companion{
        return user
    }
}