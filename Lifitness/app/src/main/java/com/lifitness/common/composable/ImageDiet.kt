package com.lifitness.common.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lifitness.R

@Composable
fun ImageDiet() {
    Image(
        painter = painterResource(R.drawable.frame_bean),
        contentScale = ContentScale.FillHeight,
        contentDescription = "Diet picture",
        modifier = Modifier
            .height(100.dp)
            .padding(5.dp)
            .clip(RoundedCornerShape(16.dp))
    )
}

@Composable
fun ImagePersonalDiet() {
        Image(
            painter = painterResource(R.drawable.healthy_diet),
            contentScale = ContentScale.FillBounds,
            contentDescription = "Personal diet picture",
            modifier = Modifier
                .fillMaxSize()
                .blur(100.dp),

        )
}


@Preview
@Composable
fun PreviewIImageDiet() {
    ImageDiet()
}

@Preview
@Composable
fun PreviewIImagePersonalDiet() {
    ImagePersonalDiet()
}