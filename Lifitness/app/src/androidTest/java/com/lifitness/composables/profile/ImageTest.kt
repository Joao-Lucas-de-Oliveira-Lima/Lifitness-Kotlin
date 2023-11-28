package com.lifitness.composables.profile

import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.lifitness.R
import com.lifitness.common.composable.EditTitle
import com.lifitness.common.composable.ImageBackground
import com.lifitness.common.composable.ImageProfile
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)

class ImageTest {
    @get:Rule
    val imageTestRule = createComposeRule()

    @Test
    fun testBackgroundImageIsDisplayed(){
            imageTestRule.setContent {
            ImageBackground()
        }

        imageTestRule.onNode(hasContentDescription("User background picture"))
            .assertExists()
    }

    @Test
    fun testProfileImageIsDisplayed(){
        imageTestRule.setContent {
            ImageProfile(R.drawable.image_16)
        }

        imageTestRule.onNode(hasContentDescription("User profile picture"))
            .assertExists()
    }
}