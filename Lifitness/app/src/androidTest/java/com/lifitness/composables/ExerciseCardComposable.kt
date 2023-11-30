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
import com.lifitness.common.composable.ExerciseCard
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExerciseCardComposable {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testShowCardExerciseTexts() {
        composeTestRule.setContent {
            ExerciseCard("TREINO DE PERNA", "20 MIN", onClick = {}, isLoading = false)
        }
        composeTestRule.onNodeWithText("TREINO DE PERNA").assertIsDisplayed()
        composeTestRule.onNodeWithText("20 MIN").assertIsDisplayed()
    }

    @Test
    fun testCardExerciseDimensions() {
        composeTestRule.setContent {
            ExerciseCard("TREINO DE BRAÇO", "20 MIN", onClick = {}, isLoading = false)
        }

        composeTestRule.onNode(hasTestTag("exercise_card"))
            .assertHeightIsAtLeast(130.dp)
    }

    @Test
    fun testShowCardExerciseImages() {
        composeTestRule.setContent {
            ExerciseCard("TREINO DE BRAÇO", "20 MIN", onClick = {}, isLoading = false)
        }
        composeTestRule.onNodeWithContentDescription("Exercise picture").assertExists()
    }

    @Test
    fun testClickableCardExerciseImages() {
        composeTestRule.setContent {
            ExerciseCard("TREINO DE BRAÇO", "20 MIN", onClick = {}, isLoading = false)
        }

        composeTestRule.onNode(hasText("TREINO DE BRAÇO"))
            .assertIsEnabled()
            .assertHasClickAction()
    }

}