package com.lifitness.composables.students

import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lifitness.common.composable.ImageBackground
import com.lifitness.common.composable.UserList
import com.lifitness.model.createMock
import org.junit.Rule
import org.junit.Test

class UserListTest {
    @get:Rule
    val userListTestRule = createComposeRule()

    @Test
    fun testUserListIsDisplayed(){
        userListTestRule.setContent {
            val navController = rememberNavController()
            UserList(users = createMock(), navController)
        }

        userListTestRule.onNode(hasText("nickname"))
            .assertExists()
    }
}