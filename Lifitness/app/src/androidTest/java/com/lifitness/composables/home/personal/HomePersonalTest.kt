package com.lifitness.composables.home.personal

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ManageSearch
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.lifitness.R
import com.lifitness.common.composable.ImageBackground
import com.lifitness.common.composable.ImageProfile
import com.lifitness.common.composable.PersonalButton
import com.lifitness.screens.home.personal.PersonalHomeScreen
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