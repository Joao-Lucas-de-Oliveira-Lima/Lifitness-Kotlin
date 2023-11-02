package com.lifitness.common.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lifitness.R
import com.lifitness.ui.theme.TextColor
import com.lifitness.R.string as AppText

@Composable
fun MoreTitle() {
    Text(
        stringResource(AppText.more_title),
        color = TextColor,
        fontFamily = FontFamily.SansSerif,
        fontSize = 24.sp,
        modifier = Modifier
            .padding(start = 20.dp)
            .padding(top = 20.dp),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun SettingsTitle() {
    Text(
        stringResource(AppText.settings_title),
        color = TextColor,
        fontFamily = FontFamily.SansSerif,
        fontSize = 24.sp,
        modifier = Modifier
            .padding(start = 20.dp)
            .padding(top = 20.dp),
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
fun EditTitle(){
    Text(stringResource(AppText.edit_title),
        color = TextColor,
        fontFamily = FontFamily.SansSerif,
        fontSize = 24.sp,
        modifier = Modifier.padding(start = 20.dp).padding(top = 20.dp),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ExerciseTitle(exerciseName: String){
    Text(text = exerciseName,
        color = TextColor,
        fontFamily = FontFamily.SansSerif,
        fontSize = 24.sp,
        modifier = Modifier.padding(start = 20.dp).padding(top = 20.dp),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ExerciseDescription(exerciseName: String){
    Text(text = exerciseName,
        color = TextColor,
        fontFamily = FontFamily.SansSerif,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = 20.dp).padding(top = 20.dp).padding(start = 5.dp).padding(end = 5.dp),
        textAlign = TextAlign.Center
    )
}
@Composable
fun DescriptionTitle(exerciseName: String){
    Text(text = exerciseName,
        color = TextColor,
        fontFamily = FontFamily.SansSerif,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 20.dp).padding(top = 20.dp).padding(bottom = 20.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
fun AmountExerciseTitle(exerciseName: String){
    Text(text = exerciseName,
        color = TextColor,
        fontFamily = FontFamily.SansSerif,
        fontSize = 50.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(top = 15.dp).padding(bottom = 25.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
fun GreetingText(text: String = stringResource(id = R.string.greeting_text)) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth(),
        style = TextStyle(
            fontSize = 15.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal
        ),
        color = Color.White,
        textAlign = TextAlign.Center
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
fun CreateAnAccountText(text: String = stringResource(id = R.string.create_an_account_text)) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth(),
        style = TextStyle(
            fontSize = 25.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold
        ),
        color = Color.White,
        textAlign = TextAlign.Center
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
        color = TextColor,
        fontFamily = FontFamily.SansSerif,
        fontSize = 20.sp,
        modifier = Modifier
            .fillMaxWidth(),
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
    )
}
