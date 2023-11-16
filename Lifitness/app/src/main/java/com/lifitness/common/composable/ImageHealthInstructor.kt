package com.lifitness.common.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lifitness.R

@Composable
fun ImageHealthInstructor() {
    Image(
        painter = painterResource(R.drawable.nutricionist),
        contentScale = ContentScale.FillHeight,
        contentDescription = "Health instructor picture",
        modifier = Modifier
            .height(100.dp)
            .padding(5.dp)
            .clip(RoundedCornerShape(16.dp))
    )
}


@Preview
@Composable
fun PreviewImageHealthInstructorImage() {
    ImageHealthInstructor()
}