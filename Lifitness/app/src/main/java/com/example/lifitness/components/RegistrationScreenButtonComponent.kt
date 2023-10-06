package com.example.lifitness.components

import android.provider.CalendarContract
import android.provider.CalendarContract.Colors
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun RegistrationScreenButtonComponent(textValue : String){
    Box(
        modifier = Modifier
            .clickable { }
            .background(Color.White, RoundedCornerShape(12.dp))
            .widthIn(280.dp)
            .heightIn(50.dp),
        contentAlignment = Alignment.Center // Centralizar conteúdo no eixo x e y
    ) {
        Text(
            text = textValue,
            textAlign = TextAlign.Center, // Centralizar texto no eixo x
        )
    }
}