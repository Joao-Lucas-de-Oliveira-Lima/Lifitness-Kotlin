package com.lifitness.screens.diets.food

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lifitness.R
import com.lifitness.common.composable.FoodTitle
import com.lifitness.common.ext.smallSpacer
import com.lifitness.common.ext.spacer
import com.lifitness.ui.theme.BackgroundColor
import com.lifitness.ui.theme.CardBackground
import com.lifitness.ui.theme.RedChart
import com.lifitness.ui.theme.TextColor

@Composable
fun FoodScreen(){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(BackgroundColor)
    ) {
        FoodTitle()
        Spacer(modifier = Modifier.spacer())

        Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "FEIJÃO", color = TextColor, fontSize = 20.sp)
            Spacer(modifier = Modifier.smallSpacer())
            Image(
                painter = painterResource(R.drawable.frame_bean),
                contentScale = ContentScale.FillHeight,
                contentDescription = "feijão",
                modifier = Modifier
                    .height(200.dp)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Spacer(modifier = Modifier.smallSpacer())
            Column {
                Text(text = "Descrição", color = TextColor, fontSize = 20.sp, modifier = Modifier
                    .padding(20.dp, 20.dp, 20.dp, 0.dp)
                    .fillMaxWidth(), textAlign = TextAlign.Start)
                Spacer(modifier = Modifier.smallSpacer())
                Text(
                    text = "O feijão carioca, também conhecido como feijão-mulatinho ou feijão-carioquinha, é uma variedade popular de feijão consumida em várias partes do mundo. Ele é uma excelente fonte de nutrientes essenciais e oferece diversos benefícios à saúde.",
                    color = TextColor,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(20.dp) )
                Spacer(modifier = Modifier.smallSpacer())
            }
            Card(border = BorderStroke(1.dp, RedChart), modifier = Modifier.padding(20.dp) ) {
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
                        text = "12.92kcal",
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
                        text = "2.31g",
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
                        text = "0.09g",
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
                        text = "0.82g",
                        color = TextColor,
                        fontSize = 16.sp,
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun FoodScreenPreview(){
    FoodScreen()
}