package com.lifitness.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertHeightIsEqualTo
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.lifitness.common.composable.DefaultButton
import com.lifitness.common.composable.SmallButton
import com.lifitness.ui.theme.ButtonColorProfile
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
@RunWith(AndroidJUnit4::class)
class ButtonTests {

    @get:Rule
    val buttonTestRule = createComposeRule()

    @Test
    fun testShowDefaultButtonText() {
        buttonTestRule.setContent {
            DefaultButton(
                contentTitle = "TESTE",
                contentIcon = Icons.Default.Person,
                onClick = { /*TODO*/ },
                buttonColor = ButtonColorProfile
            )
        }

        buttonTestRule.onNode(hasText("TESTE"))
            .assertExists()
    }

    @Test
    fun testButtonHeight() {
        buttonTestRule.setContent {
            DefaultButton(
                contentTitle = "TESTE",
                contentIcon = Icons.Default.Person,
                onClick = { /*TODO*/ },
                buttonColor = ButtonColorProfile
            )
        }

        buttonTestRule.onNode(hasText("TESTE"))
            .assertHeightIsEqualTo(85.dp)
    }

    @Test
    fun testButtonIsDisplayed() {
        buttonTestRule.setContent {
            DefaultButton(
                contentTitle = "TESTE",
                contentIcon = Icons.Default.Person,
                onClick = { /*TODO*/ },
                buttonColor = ButtonColorProfile
            )
        }

        buttonTestRule.onNode(hasText("TESTE"))
            .assertIsDisplayed()
    }

    @Test
    fun testButtonIsEnable() {
        buttonTestRule.setContent {
            DefaultButton(
                contentTitle = "TESTE",
                contentIcon = Icons.Default.Person,
                onClick = { /*TODO*/ },
                buttonColor = ButtonColorProfile
            )
        }

        buttonTestRule.onNode(hasText("TESTE"))
            .assertIsEnabled()
    }

    @Test
    fun testSmallButtonIsEnable() {
        buttonTestRule.setContent {
            SmallButton(
                contentTitle = "TESTE",
                onClick = { /*TODO*/ },
                buttonColor = ButtonColorProfile
            )
        }

        buttonTestRule.onNode(hasText("TESTE"))
            .assertIsEnabled()
    }

    @Test
    fun testSmallButtonHeight() {
        buttonTestRule.setContent {
            SmallButton(
                contentTitle = "TESTE",
                onClick = { /*TODO*/ },
                buttonColor = ButtonColorProfile
            )
        }

        buttonTestRule.onNode(hasText("TESTE"))
            .assertHeightIsEqualTo(60.dp)
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Test
    fun testClickableText(){
        buttonTestRule.setContent {
            ClickableText(
                AnnotatedString("test"), {}, Modifier, TextStyle(), true, TextOverflow.Clip, Int.MAX_VALUE, {}, {}
            )
        }
        buttonTestRule.onAllNodes(hasClickAction()).assertCountEquals(0)

    }
}