package com.lifitness.common.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.lifitness.R

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
