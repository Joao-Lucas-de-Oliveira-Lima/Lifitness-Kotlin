package com.lifitness.screens.diets.food

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lifitness.R
import com.lifitness.common.composable.FoodTitle
import com.lifitness.common.ext.endOfScreenSpacer
import com.lifitness.common.ext.smallSpacer
import com.lifitness.common.ext.spacer
import com.lifitness.model.Food
import com.lifitness.ui.theme.BackgroundColor
import com.lifitness.ui.theme.CardBackground
import com.lifitness.ui.theme.RedChart
import com.lifitness.ui.theme.TextColor

@Composable
fun FoodScreen(
    navController: NavHostController,
    diet: Food
){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(BackgroundColor)
            .verticalScroll(rememberScrollState())
    ) {
        FoodTitle()
        Spacer(modifier = Modifier.spacer())

        Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = diet.dietName, color = TextColor, fontSize = 20.sp)
            Spacer(modifier = Modifier.smallSpacer())
            Image(
                painter = painterResource(R.drawable.frame_bean),
                contentScale = ContentScale.FillHeight,
                contentDescription = "foodImage",
                modifier = Modifier
                    .height(200.dp)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Spacer(modifier = Modifier.smallSpacer())
            Column(modifier = Modifier.background(CardBackground)) {

                Text(text = "Descrição", color = TextColor, fontSize = 20.sp, modifier = Modifier
                    .padding(20.dp, 20.dp, 20.dp, 0.dp)
                    .fillMaxWidth(), textAlign = TextAlign.Start)
                Spacer(modifier = Modifier.smallSpacer())
                Text(
                    text = diet.dietDescription,
                    color = TextColor,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(20.dp) )
                Spacer(modifier = Modifier.smallSpacer())
            }
            Card(border = BorderStroke(1.dp, RedChart), modifier = Modifier.padding(0.dp, 20.dp, 0.dp, 20.dp) ) {
                Row(modifier = Modifier.background(CardBackground)) {
                    Text(
                        text = "Tabela nutricional",
                        color = TextColor,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    Card(border = BorderStroke(1.dp, RedChart), modifier = Modifier.height(1.dp)) {

                    }
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .background(CardBackground)
                        .fillMaxWidth()
                        .padding(0.dp, 10.dp),
                ) {
                    Text(
                        text = "Calorias",
                        color = TextColor,
                        fontSize = 16.sp,
                    )
                    Text(
                        text = diet.dietNutricionalTable[0],
                        color = TextColor,
                        fontSize = 16.sp,
                    )

                }
                Card(border = BorderStroke(1.dp, RedChart), modifier = Modifier.height(1.dp)) {

                }
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .background(CardBackground)
                        .fillMaxWidth()
                        .padding(0.dp, 10.dp),) {
                    Text(
                        text = "Carboidrato",
                        color = TextColor,
                        fontSize = 16.sp,
                    )
                    Text(
                        text = diet.dietNutricionalTable[1],
                        color = TextColor,
                        fontSize = 16.sp,
                    )
                }
                Card(border = BorderStroke(1.dp, RedChart), modifier = Modifier.height(1.dp)) {

                }
                Row(horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .background(CardBackground)
                        .fillMaxWidth()
                        .padding(0.dp, 10.dp),) {
                    Text(
                        text = "Gorduras",
                        color = TextColor,
                        fontSize = 16.sp,
                    )
                    Text(
                        text = diet.dietNutricionalTable[2],
                        color = TextColor,
                        fontSize = 16.sp,
                    )
                }
                Card(border = BorderStroke(1.dp, RedChart), modifier = Modifier.height(1.dp)) {

                }
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .background(CardBackground)
                        .fillMaxWidth()
                        .padding(0.dp, 20.dp, 0.dp, 20.dp),) {
                    Text(
                        text = "Proteinas",
                        color = TextColor,
                        fontSize = 16.sp,
                    )
                    Text(
                        text = diet.dietNutricionalTable[3],
                        color = TextColor,
                        fontSize = 16.sp,
                    )
                }
            }
        }
        Spacer(modifier = Modifier.endOfScreenSpacer())
    }
}

@Composable
@Preview
fun FoodScreenPreview(){
    val navController = rememberNavController()
    //FoodScreen(navController)
}