package com.lifitness.screens.home.personal

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ManageAccounts
import androidx.compose.material.icons.filled.ManageSearch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lifitness.common.composable.HomeTitle
import com.lifitness.common.composable.PersonalButton
import com.lifitness.common.ext.spacer

@Composable
fun PersonalHomeScreen(){
    Column(modifier = Modifier.fillMaxHeight().fillMaxWidth()) {
        HomeTitle()
        Spacer(modifier = Modifier.spacer())
        PersonalButton(
            contentTitle = "MANAGE STUDENTS",
            contentIcon = Icons.Default.ManageAccounts,
            onClick = {}
        )
        Spacer(modifier = Modifier.spacer())
        PersonalButton(
            contentTitle = "MANAGE TRAINS",
            contentIcon = Icons.Default.ManageSearch,
            onClick = {}
        )
    }
}

@Composable
@Preview
fun PersonalHomeScreenPreview(){
    PersonalHomeScreen()
}