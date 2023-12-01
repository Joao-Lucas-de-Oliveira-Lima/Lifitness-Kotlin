package com.lifitness.composables.profile

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import coil.compose.rememberImagePainter
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
            val painter: Painter = rememberImagePainter("https://via.placeholder.com/150/007bff/ffffff?text=Homem" )
            ImageProfile(painter)
        }

        imageTestRule.onNode(hasContentDescription("User profile picture"))
            .assertExists()
    }
}