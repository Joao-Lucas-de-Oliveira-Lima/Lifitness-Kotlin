package com.lifitness.common.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lifitness.R

@Composable
fun ImageExercise() {
    Image(
        painter = painterResource(R.drawable.frame_leg),
        contentScale = ContentScale.FillHeight,
        contentDescription = "Exercise picture",
        modifier = Modifier
            .height(130.dp)
    )
}
@Composable
fun ImageExerciseDescription() {
    Image(
        painter = painterResource(R.drawable.squatting_description),
        contentScale = ContentScale.FillBounds,
        contentDescription = "Exercise picture",
        modifier = Modifier
            .height(230.dp)
            .fillMaxWidth()
    )
}


@Preview
@Composable
fun PreviewExerciseImage() {
    ImageExercise()
}

@Preview
@Composable
fun PreviewImageExerciseDescription() {
    ImageExerciseDescription()
}
