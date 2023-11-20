package com.lifitness.common.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lifitness.ui.theme.CardBackground

@Composable
fun HealthInstructorCard(instructorName: String, onClick: () -> Unit) {
    EditorHealthInstructorCardCard(instructorName, onClick)
}

@Composable
fun EditorHealthInstructorCardCard(healthInstructorName: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clickable(onClick = { onClick() })
            .testTag("health_instructor_card")

    ) {
        Card(
            modifier = Modifier
                .width(130.dp)
                .height(130.dp)
                .padding(5.dp)
                .clip(RoundedCornerShape(15)),
            colors = CardDefaults.cardColors(
                containerColor = CardBackground
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ImageHealthInstructor()
                SpecificHealthInstructorName(healthInstructorName)
            }
        }
    }
}



@Preview
@Composable
fun PreviewHealthInstructorCardCard() {
    HealthInstructorCard("Cassandra", onClick = {})
}