package com.lifitness.screens.addTrain

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lifitness.app.LifitnessScreen
import com.lifitness.common.composable.AddTrainTitle
import com.lifitness.common.composable.SmallButton
import com.lifitness.common.composable.TextFieldComponent
import com.lifitness.common.ext.endOfScreenSpacer
import com.lifitness.common.ext.spacer
import com.lifitness.ui.theme.BackgroundColor
import com.lifitness.ui.theme.CardBackground
import com.lifitness.ui.theme.CardGreen
import com.lifitness.ui.theme.Divider
import com.lifitness.ui.theme.TextColor

@Composable
fun AddTrainScreen(navController: NavHostController){
    Column(modifier = Modifier
        .fillMaxWidth()
        .verticalScroll(rememberScrollState())
        .fillMaxHeight()
        .background(BackgroundColor)) {
        AddTrainTitle()
        Spacer(modifier = Modifier.spacer())
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            LazyColumn(
                modifier = Modifier
                    .height(500.dp)
                    .fillMaxWidth()
                    .background(CardBackground)
            ){
                item {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = "EXERCISES", color = TextColor, fontSize = 18.sp, modifier = Modifier.padding(top = 20.dp, start = 20.dp))
                        Button(
                            onClick = { navController.navigate(LifitnessScreen.AddExercise.name) },
                            colors = ButtonDefaults.buttonColors(BackgroundColor),
                            border = BorderStroke(2.dp, CardGreen),
                            modifier = Modifier
                                .padding(top = 10.dp, end = 20.dp)
                        ) {
                            Icon(
                                Icons.Default.Add,
                                contentDescription = "Add exercise button",
                                tint = CardGreen,
                            )
                        }
                    }
                }
                items(5){
                    Spacer(modifier = Modifier.spacer())
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .background(Divider)
                        .height(1.dp)) {
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                        Spacer(modifier = Modifier.spacer())
                        Text(text = "Bulgarian", color = TextColor, fontSize = 16.sp)
                    }
                }
            }
            Spacer(modifier = Modifier.spacer())
            TextFieldComponent(labelValue = "Name")
            Spacer(modifier = Modifier.spacer())
            SmallButton(contentTitle = "ADD", onClick = { navController.navigate(LifitnessScreen.TrainList.name) }, buttonColor = CardBackground)
            Spacer(modifier = Modifier.endOfScreenSpacer())
        }
    }
}

@Composable
@Preview
fun AddTrainScreenPreview(){
    val navController = rememberNavController()
    AddTrainScreen(navController)
}