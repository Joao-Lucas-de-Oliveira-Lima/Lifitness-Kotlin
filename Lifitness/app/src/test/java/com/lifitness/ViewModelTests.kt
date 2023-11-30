package com.lifitness

import com.lifitness.screens.editProfile.EditProfileViewModel
import com.lifitness.screens.login.user
import com.lifitness.screens.profile.ProfileViewModel
import com.lifitness.singleton.LoggedInUserSingleton
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.jupiter.api.assertTimeout

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ViewModelTests {

    @Test
    fun testGetUserFromDatabase(){
        val user = LoggedInUserSingleton.getInstance()
        val profileViewModel: ProfileViewModel = ProfileViewModel()
        assertEquals(user, profileViewModel.getUserInfo().getInstance())
    }
}