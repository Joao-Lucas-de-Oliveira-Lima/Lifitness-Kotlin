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
import com.lifitness.common.ext.shimmerLoadingAnimation
import com.lifitness.ui.theme.CardBackground

@Composable

fun DietRecommendationCard(foodName: String, dietCal: String, isLoadingCompleted: Boolean, onClick: () -> Unit) {
    EditorDietRecomendationCard(foodName, dietCal, onClick, isLoadingCompleted)
}

@Composable
fun EditorDietRecomendationCard(healthInstructorName: String, dietCal: String, onClick: () -> Unit, isLoadingCompleted: Boolean) {
    Box(
        modifier = Modifier
            .clickable(onClick = { onClick() })
            .testTag("diet_card")
    ) {
        Card(
            modifier = Modifier
                .width(130.dp)
                .height(140.dp)
                .padding(5.dp)
                .clip(RoundedCornerShape(15)),
            colors = CardDefaults.cardColors(
                containerColor = CardBackground
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .shimmerLoadingAnimation(isLoadingCompleted),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if(isLoadingCompleted) {
                    ImageDiet()
                    SpecificDietName(healthInstructorName)
                    SpecificDietCal(dietCal)
                }
            }
        }
    }
}



@Preview
@Composable
fun PreviewDietRecommendationCard() {

    DietRecommendationCard("Cassandra", "200CAL", true, onClick = {})
}