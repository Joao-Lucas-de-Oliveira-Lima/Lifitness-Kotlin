package com.lifitness.screens.trainList

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lifitness.app.LifitnessScreen
import com.lifitness.common.composable.TrainListTitle
import com.lifitness.common.ext.smallSpacer
import com.lifitness.common.ext.spacer
import com.lifitness.ui.theme.BackgroundColor
import com.lifitness.ui.theme.CardBackground
import com.lifitness.ui.theme.CardGreen
import com.lifitness.ui.theme.RedChart

@Composable
fun TrainListScreen(navController: NavHostController){
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .background(color = BackgroundColor)
        .fillMaxHeight()
        .fillMaxWidth()) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            TrainListTitle()
            Button(
                onClick = { navController.navigate(LifitnessScreen.AddTrain.name) },
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
        Spacer(modifier = Modifier.spacer())
        LazyColumn(modifier = Modifier.height(700.dp)){
            items(5){
                TrainCard(onClick = { }, deleteOnClick = { /*TODO*/ }, trainName = "Perna")
                Spacer(modifier = Modifier.smallSpacer())
            }
        }
    }
}

@Composable
fun TrainCard(onClick: () -> Unit, deleteOnClick: () -> Unit, trainName: String){
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(CardBackground),
        shape = RoundedCornerShape(10),
        modifier = Modifier.padding(20.dp, 5.dp).fillMaxWidth()
        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
            ) {
            Text(text = trainName, fontSize = 16.sp)
            Button(
                onClick = deleteOnClick,
                colors = ButtonDefaults.buttonColors(Color.Transparent)) {
                Icon(
                    Icons.Default.Delete,
                    contentDescription = "Delete train button",
                    tint = RedChart,
                )
            }
        }
    }
}

@Preview
@Composable
fun TrainCardPreview(){
    TrainCard({}, {}, "Perna")
}

@Preview
@Composable
fun TrainListScreenPreview(){
    val navController = rememberNavController()
    TrainListScreen(navController)
}