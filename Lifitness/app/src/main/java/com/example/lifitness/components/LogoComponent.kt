package com.example.lifitness.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.lifitness.R

@Composable
fun LogoComponent(){
    Image(
        painter = painterResource(id = R.drawable.lifitnesslogo),
        contentDescription = "Logo",
        modifier = Modifier
            .heightIn(min = 70.dp)
            .widthIn(min = 76.dp)
    )
}
