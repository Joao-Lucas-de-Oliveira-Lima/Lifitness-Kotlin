package com.lifitness.composables.students

import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
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
            UserList(users = createMock())
        }

        userListTestRule.onNode(hasText("test"))
            .assertExists()
    }
}