package com.lifitness.composables.home.client

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.lifitness.common.composable.ExerciseCard
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomePersonalTest {
    @get:Rule
    val homeRule = createComposeRule()

    @Test
    fun testButtonsClick(){
        homeRule.setContent {
            ExerciseCard("test", "12x9", false) {
            }
        }
        homeRule.onNode(hasClickAction())
            .assertHasClickAction()
    }
}