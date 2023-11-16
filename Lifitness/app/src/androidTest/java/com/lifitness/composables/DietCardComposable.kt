package com.lifitness.composables

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
import com.lifitness.common.composable.DietRecomendationCard
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
            DietRecomendationCard("Feijoada","300CAL" )
        }
        composeTestRule.onNodeWithText("Feijoada").assertIsDisplayed()
        composeTestRule.onNodeWithText("300CAL").assertIsDisplayed()
    }

    @Test
    fun testCardDietDimensions() {
        composeTestRule.setContent {
            DietRecomendationCard("Feijoada","300CAL" )
        }

        composeTestRule.onNode(hasTestTag("diet_card"))
            .assertHeightIsAtLeast(120.dp)
    }

    @Test
    fun testShowCardDietImages() {
        composeTestRule.setContent {
            DietRecomendationCard("Feijoada","300CAL" )
        }
        composeTestRule.onNodeWithContentDescription("Diet picture").assertExists()
    }

    @Test
    fun testClicableCardDietImages() {
        composeTestRule.setContent {
            DietRecomendationCard("Feijoada","300CAL" )
        }

        composeTestRule.onNode(hasText("Feijoada"))
            .assertIsEnabled()
    }
}