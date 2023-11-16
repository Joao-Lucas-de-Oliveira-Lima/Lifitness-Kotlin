package com.lifitness.common.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lifitness.ui.theme.CardBackground

@Composable
fun PersonalDietCard(exerciseName: String, dietCal: String) {
    EditorPersonalDietCard(exerciseName, dietCal)
}

@Composable
fun EditorPersonalDietCard(healthInstructorName: String, dietCal: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .padding(5.dp)
            .clip(RoundedCornerShape(15)),
        colors = CardDefaults.cardColors(
            containerColor = CardBackground
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            ImagePersonalDiet()
            HirePersonalDietTitle()
        }
    }
}



@Preview
@Composable
fun PreviewEditorPersonalDietCard() {
    PersonalDietCard(exerciseName = "Cassandra", "200CAL")
}