package com.lifitness.screens.studentsPersonal


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lifitness.common.composable.AddClientTitle
import com.lifitness.common.composable.ClientListTitle
import com.lifitness.common.composable.UserList
import com.lifitness.common.ext.spacer
import com.lifitness.model.createMock
import com.lifitness.ui.theme.BackgroundColor
import com.lifitness.ui.theme.CardBackground
import com.lifitness.ui.theme.TextColor

@Composable
fun ClientsListScreen(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(BackgroundColor)
    ){
        Column(modifier = Modifier.fillMaxWidth()) {
            AddClientTitle()
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 10.dp),
                value = "",
                onValueChange = {},
                label = { Text("Username", Modifier.background(CardBackground), TextColor, fontWeight = FontWeight.Bold) },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = TextColor, // Cor do texto
                    backgroundColor = CardBackground, // Cor de fundo
                    cursorColor = Color.White, // Cor do cursor
                    focusedIndicatorColor = Color.Green, // Cor da linha de foco
                    unfocusedIndicatorColor = Color.Gray, // Cor da linha quando não está em foco
                    disabledIndicatorColor = Color.Red, // Cor da linha quando desabilitado
                    errorIndicatorColor = Color.Red // Cor da linha quando há erro
                ))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Button(
                    colors = ButtonDefaults.buttonColors(CardBackground),
                    onClick = { /*TODO*/ },

                    ) {
                    Text(text = "ADD")
                }
            }
            ClientListTitle()
        }
        Spacer(modifier = Modifier.spacer())
        UserList(createMock(), navController)
    }
}

@Composable
fun AddUserComposable(){

}

@Preview
@Composable
fun ClientsListScreenPreview(){
    val navController = rememberNavController()
    ClientsListScreen(navController)
}
