package com.lifitness.composables.editProfile

import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.lifitness.common.composable.EditTitle
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TitleTest {

    @get:Rule
    val titleTestRule = createComposeRule()

    @Test
    fun testTitleIsDisplayed(){
        titleTestRule.setContent {
            EditTitle()
        }

        titleTestRule.onNode(hasText("EDIT PROFILE"))
            .assertExists()
    }
}