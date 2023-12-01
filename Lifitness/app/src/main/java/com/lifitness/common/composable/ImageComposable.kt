package com.lifitness.common.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.lifitness.R
import com.lifitness.R.drawable as AppImages

@Composable
fun ImageProfile(painter: Painter) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painter,
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

@Composable
fun LogoComponent(minWidth: Int, minHeight: Int) {
    Image(
        painter = painterResource(id = R.drawable.lifitnesslogo),
        contentDescription = "Logo",
        modifier = Modifier
            .heightIn(min = minHeight.dp)
            .widthIn(min = minWidth.dp)
    )
}

@Preview
@Composable
fun PreviewLogoImage() {
    LogoComponent(60, 70)
}

@Preview
@Composable
fun PreviewImageProfile() {
    val painter: Painter = rememberImagePainter("    ImageProfile(\"https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.wilsoncenter.org%2Fperson%2Fjames-person&psig=AOvVaw2waumFKOZQHjQ9p57BVjOH&ust=1701315267453000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCLjdkrOj6IIDFQAAAAAdAAAAABAE\")\n")
    ImageProfile(painter)
}

@Preview
@Composable
fun PreviewImageBackground() {
    ImageBackground()
}
