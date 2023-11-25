package com.lifitness.composables

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertHeightIsAtLeast
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.unit.dp
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.lifitness.common.composable.DietRecommendationCard
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DietCardComposable {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testShowCardDietTexts() {
        composeTestRule.setContent {
            DietRecommendationCard("Feijoada","300CAL", true, onClick = {})
        }
        composeTestRule.onNodeWithText("Feijoada").assertIsDisplayed()
        composeTestRule.onNodeWithText("300CAL").assertIsDisplayed()
    }

    @Test
    fun testCardDietDimensions() {
        composeTestRule.setContent {
            DietRecommendationCard("Feijoada","300CAL",true, onClick = {} )
        }

        composeTestRule.onNode(hasTestTag("diet_card"))
            .assertHeightIsAtLeast(140.dp)
    }

    @Test
    fun testShowCardDietImages() {
        composeTestRule.setContent {
            DietRecommendationCard("Feijoada","300CAL", true, onClick = {} )
        }
        composeTestRule.onNodeWithContentDescription("Diet picture").assertExists()
    }

    @Test
    fun testClicableCardDietImages() {
        composeTestRule.setContent {
            DietRecommendationCard("Feijoada","300CAL", true, onClick = {})
        }

        composeTestRule.onNode(hasText("Feijoada"))
            .assertIsEnabled()
            .assertHasClickAction()
    }
}