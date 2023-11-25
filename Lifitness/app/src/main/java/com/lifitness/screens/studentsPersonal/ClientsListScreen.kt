package com.lifitness.screens.studentsPersonal

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lifitness.common.composable.ClientsTitle
import com.lifitness.common.composable.UserList
import com.lifitness.common.ext.spacer
import com.lifitness.model.createMock
import com.lifitness.ui.theme.BackgroundColor
import com.lifitness.ui.theme.CardGreen

@Composable
fun ClientsListScreen(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(BackgroundColor)
    ){
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()){
            ClientsTitle()
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(BackgroundColor),
                border = BorderStroke(2.dp, CardGreen),
                modifier = Modifier
                    .padding(top = 10.dp, end = 20.dp)
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Add client button",
                    tint = CardGreen,
                )
            }
        }
        Spacer(modifier = Modifier.spacer())
        UserList(createMock(), navController)
    }
}

@Preview
@Composable
fun ClientsListScreenPreview(){
    val navController = rememberNavController()
    ClientsListScreen(navController)
}
