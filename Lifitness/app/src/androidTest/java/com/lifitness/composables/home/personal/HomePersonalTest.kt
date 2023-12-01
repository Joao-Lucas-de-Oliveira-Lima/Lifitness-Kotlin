package com.lifitness.composables.home.personal

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ManageSearch
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.lifitness.common.composable.PersonalButton
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
            PersonalButton(contentTitle = "Test", contentIcon = Icons.Default.ManageSearch) {
            }
        }
        homeRule.onNode(hasClickAction())
            .assertHasClickAction()
    }
}