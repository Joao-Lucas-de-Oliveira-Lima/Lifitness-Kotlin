package com.lifitness.composables.editProfile

import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.lifitness.common.composable.TextFieldComponent
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class InputTextTest {

    @get:Rule
    val inputTestRule = createComposeRule()

    @Test
    fun testInputShowText(){
        inputTestRule.setContent {
            TextFieldComponent(labelValue = "Test")
        }

        inputTestRule.onNode(hasText("Test"))
            .assertExists()
    }

    @Test
    fun testInputIsClickable(){
        inputTestRule.setContent {
            TextFieldComponent(labelValue = "Test")
        }

        inputTestRule.onNode(hasClickAction())
            .assertExists()
    }


}