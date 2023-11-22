package com.lifitness.screens.studentsPersonal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lifitness.common.composable.ClientsTitle
import com.lifitness.common.composable.UserList
import com.lifitness.common.ext.spacer
import com.lifitness.model.createMock
import com.lifitness.ui.theme.BackgroundColor

@Composable
fun ClientsListScreen(){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(BackgroundColor)
    ){
        ClientsTitle()
        Spacer(modifier = Modifier.spacer())
        UserList(createMock())
    }
}

@Preview
@Composable
fun ClientsListScreenPreview(){
    ClientsListScreen()
}
