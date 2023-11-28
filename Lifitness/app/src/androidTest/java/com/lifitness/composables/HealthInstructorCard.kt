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
import com.lifitness.common.composable.HealthInstructorCard
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HealthInstructorCard {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testShowCardHealthInstructorTexts(){
        composeTestRule.setContent {
            HealthInstructorCard("Clécia", onClick = {})
        }
        composeTestRule.onNodeWithText("Clécia").assertIsDisplayed()
    }

    @Test
    fun testShowCardHealthInstructorDimensions(){
        composeTestRule.setContent {
            HealthInstructorCard("Clécia", onClick = {})
        }

        composeTestRule.onNode(hasTestTag("health_instructor_card"))
            .assertHeightIsAtLeast(130.dp)
    }

    @Test
    fun testShowCardHealthInstructorImages(){
        composeTestRule.setContent {
            HealthInstructorCard("Clécia", onClick = {})
        }
        composeTestRule.onNodeWithContentDescription("Health instructor picture").assertExists()
    }

    @Test
    fun testClickableCardHealthImages(){
        composeTestRule.setContent {
            HealthInstructorCard("Clécia", onClick = {})
        }

        composeTestRule.onNode(hasText("Clécia"))
            .assertIsEnabled()
            .assertHasClickAction()
    }

}