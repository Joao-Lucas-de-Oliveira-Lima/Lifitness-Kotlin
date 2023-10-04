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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lifitness.R.drawable as AppImages

@Composable
fun ImageProfile() {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(AppImages.ic_launcher_foreground),
            contentDescription = "User profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
    }
}

@Composable
fun ImageBackground() {
    Row(modifier = Modifier.padding(vertical = 12.dp)) {
        Image(
            painter = painterResource(AppImages.ic_launcher_background),
            contentDescription = "User background picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
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
