package com.example.lifitness.common.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lifitness.R.drawable as AppImages

@Composable
fun ImageProfile() {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(AppImages.image_16),
            contentDescription = "User profile picture",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
        )
    }
}

@Composable
fun ImageBackground() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(AppImages.frame_3),
            contentDescription = "User background picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun PreviewImageProfile(){
    ImageProfile()
}

@Preview
@Composable
fun PreviewImageBackground(){
    ImageBackground()
}
