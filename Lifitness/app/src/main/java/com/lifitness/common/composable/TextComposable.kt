package com.lifitness.common.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lifitness.R.string as AppText
import com.lifitness.ui.theme.TextColor

@Composable
fun MoreTitle(){
    Text(stringResource(AppText.more_title),
        color = TextColor,
        fontFamily = FontFamily.SansSerif,
        fontSize = 24.sp,
        modifier = Modifier.padding(start = 20.dp).padding(top = 20.dp),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun SettingsTitle(){
    Text(stringResource(AppText.settings_title),
        color = TextColor,
        fontFamily = FontFamily.SansSerif,
        fontSize = 24.sp,
        modifier = Modifier.padding(start = 20.dp).padding(top = 20.dp),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun TrainsTitle(){
    Text(stringResource(AppText.trains_title),
        color = TextColor,
        fontFamily = FontFamily.SansSerif,
        fontSize = 24.sp,
        modifier = Modifier.padding(start = 20.dp).padding(top = 20.dp),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun BegginerTitle(){
    Text(stringResource(AppText.begginer_title),
        color = TextColor,
        fontFamily = FontFamily.SansSerif,
        fontSize = 20.sp,
        modifier = Modifier.padding(start = 20.dp).padding(top = 20.dp),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun HireInstructorTitle(){
    Text(stringResource(AppText.hireInstructor_title),
        color = TextColor,
        fontFamily = FontFamily.SansSerif,
        fontSize = 20.sp,
        modifier = Modifier.padding(start = 20.dp).padding(top = 20.dp),
        fontWeight = FontWeight.Bold
    )
}
@Composable
fun HireNutricionistTitle(){
    Text(stringResource(AppText.hireNutricionist_title),
        color = TextColor,
        fontFamily = FontFamily.SansSerif,
        fontSize = 20.sp,
        modifier = Modifier.padding(start = 20.dp).padding(top = 20.dp),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun DietsRecomendationTitle(){
    Text(stringResource(AppText.dietsRecomendation_title),
        color = TextColor,
        fontFamily = FontFamily.SansSerif,
        fontSize = 20.sp,
        modifier = Modifier.padding(start = 20.dp).padding(top = 20.dp),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun IntermediateTitle(){
    Text(stringResource(AppText.intermediate_title),
        color = TextColor,
        fontFamily = FontFamily.SansSerif,
        fontSize = 20.sp,
        modifier = Modifier.padding(start = 20.dp).padding(top = 20.dp),
        fontWeight = FontWeight.Bold
    )
}
@Composable
fun SpecificTrainTitle(trainName: String){
    Text(trainName,
        color = TextColor,
        fontFamily = FontFamily.SansSerif,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun SpecificTrainDuration(trainDuration: String)
{
    Text(trainDuration,
        color = TextColor,
        fontFamily = FontFamily.SansSerif,
        fontSize = 10.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun SpecificHealthInstructorName(instructorName: String){
    Text(instructorName,
        color = TextColor,
        fontFamily = FontFamily.SansSerif,
        fontSize = 10.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun SpecificDietName(dietName: String){
    Text(dietName,
        color = TextColor,
        fontFamily = FontFamily.SansSerif,
        fontSize = 10.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun SpecificDietCal(dietCal: String){
    Text(dietCal,
        color = Color.Gray,
        fontFamily = FontFamily.SansSerif,
        fontSize = 5.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun DietsTitle(){
    Text(stringResource(AppText.diets_title),
        color = TextColor,
        fontFamily = FontFamily.SansSerif,
        fontSize = 24.sp,
        modifier = Modifier.padding(start = 20.dp).padding(top = 20.dp),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun PersonalNutricionistTitle(){
    Text(stringResource(AppText.personalDiet_title),
        color = TextColor,
        fontFamily = FontFamily.SansSerif,
        fontSize = 20.sp,
        modifier = Modifier.padding(start = 20.dp).padding(top = 20.dp),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ContratPersonalDietTitle(){
    Text(stringResource(AppText.hirePersonalDiet_title),
        color = Color.Black,
        fontFamily = FontFamily.SansSerif,
        fontSize = 20.sp,
        modifier = Modifier
            .fillMaxWidth(),
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
    )
}
