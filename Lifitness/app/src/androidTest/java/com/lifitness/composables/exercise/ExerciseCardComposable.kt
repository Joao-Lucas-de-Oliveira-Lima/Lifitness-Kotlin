package com.lifitness.composables.exercise

import androidx.compose.ui.test.assertHeightIsEqualTo
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.unit.dp
import com.lifitness.common.composable.ExerciseCard
import org.junit.Rule
import org.junit.Test

class ExerciseCardComposable {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testShowCardExerciseTexts(){
        composeTestRule.setContent {
            ExerciseCard("TREINO DE PERNA", "20 MIN")
        }
        composeTestRule.onNodeWithText("TREINO DE PERNA").assertIsDisplayed()
        composeTestRule.onNodeWithText("20 MIN").assertIsDisplayed()
    }

    @Test
    fun testCardExerciseDimensions(){
        composeTestRule.setContent {
            ExerciseCard("TREINO DE BRAÇO", "20 MIN")
        }

        /*composeTestRule.onNode(hasTestTag("exercise_card"))
            .assertHeightIsEqualTo(130.dp)*/
    }

    @Test
    fun testShowCardExerciseImages(){
        composeTestRule.setContent {
            ExerciseCard("TREINO DE BRAÇO", "20 MIN")
        }
        composeTestRule.onNodeWithContentDescription("Exercise picture").assertExists()
    }

    @Test
    fun testClicableCardExerciseImages(){
        composeTestRule.setContent {
            ExerciseCard("TREINO DE BRAÇO", "20 MIN")
        }

        composeTestRule.onNode(hasText("TREINO DE BRAÇO"))
            .assertIsEnabled()
    }

}