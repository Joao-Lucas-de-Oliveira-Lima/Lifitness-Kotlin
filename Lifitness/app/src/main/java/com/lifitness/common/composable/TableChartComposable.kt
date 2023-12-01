package com.lifitness.common.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lifitness.common.ext.endOfScreenSpacer
import com.lifitness.common.ext.smallSpacer
import com.lifitness.common.ext.spacer
import com.lifitness.model.Exercise
import com.lifitness.model.Train
import com.lifitness.model.User
import com.lifitness.model.createSingleMock
import com.lifitness.screens.exerciseList.student.ExerciseListViewModel
import com.lifitness.ui.theme.CardBackground
import com.lifitness.ui.theme.CardGreen
import com.lifitness.ui.theme.GrayCard

val trains: List<Train> = createSingleMock().trains

@Composable
fun TableChartComposable(){
    Column(modifier = Modifier
        .background(CardBackground)
        .padding(5.dp)) {
        Row (horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()){
            Text(text = "Exercises", color = Color.White)
            Text(text = "Train", color = Color.White)
            Text(text = "Duration", color = Color.White)
        }
        Spacer(modifier = Modifier.spacer())
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .height(230.dp)
            .background(CardBackground)){

            items(trains){ train ->
                Row(horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(CardGreen)
                        .height(35.dp)) {
                    val exercisesViewModelList: ExerciseListViewModel = viewModel()
                    exercisesViewModelList.fetchExercisesForTrain(train.trainId)
                    val exercises = exercisesViewModelList.exercises.observeAsState()
                    Text(
                        text = exercises.value?.size.toString(),
                        color = Color.Black,
                        modifier = Modifier
                            .align(alignment = Alignment.CenterVertically).padding(20.dp, 0.dp),
                        fontWeight = FontWeight(700),
                        fontFamily = FontFamily.SansSerif
                    )
                    Text(
                        text = train.trainName,
                        color = Color.Black,
                        modifier = Modifier
                            .align(alignment = Alignment.CenterVertically),
                        fontWeight = FontWeight(700),
                        fontFamily = FontFamily.SansSerif
                    )

                    Text(text = train.duration, color = Color.Black, modifier = Modifier
                            .align(alignment = Alignment.CenterVertically),
                        fontWeight = FontWeight(700),
                        fontFamily = FontFamily.SansSerif,
                    )

                }
                Spacer(modifier = Modifier.smallSpacer().background(GrayCard))
            }
        }
    }

}
@Preview
@Composable
fun PreviewTableChartComposable(){
    TableChartComposable()
}