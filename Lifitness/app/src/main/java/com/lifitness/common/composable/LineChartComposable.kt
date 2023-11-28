package com.lifitness.common.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.LineType
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine
import com.lifitness.model.createSingleMock
import com.lifitness.ui.theme.CardBackground
import com.lifitness.ui.theme.RedChart
import com.lifitness.ui.theme.GrayCard
val weightList: List<Double> = createSingleMock().weight

fun WeightToPoints(): List<Point>{
    val weightPoints: MutableList<Point> = mutableListOf()
    weightList.forEachIndexed { index, weight ->
        val point = Point(index.toFloat(), weight.toFloat())
        weightPoints.add(point)
    }
    return weightPoints
}


@Composable
fun WeightLineChart() {
    val weights = weightList.size
    val pointsData: List<Point> = WeightToPoints()
    val xAxisData = AxisData.Builder()
        .axisStepSize(100.dp)
        .backgroundColor(CardBackground)
        .steps(pointsData.size - 1)
        .labelData { i -> (i).toString() }
        .labelAndAxisLinePadding(15.dp)
        .axisLineColor(GrayCard)
        .axisLabelColor(Color.White)
        .build()

    val yAxisData = AxisData.Builder()
        .steps(weights)
        .backgroundColor(CardBackground)
        .labelData { i ->
            val yScale = 100 / weights
            (i * yScale).toString()
        }
        .labelAndAxisLinePadding(20.dp)
        .axisLineColor(GrayCard)
        .axisLabelColor(Color.White)
        .build()

    val lineChartData = LineChartData(
        linePlotData = LinePlotData(
            lines = listOf(
                Line(
                    dataPoints = pointsData,
                    LineStyle(
                        color = RedChart,
                        lineType = LineType.Straight(isDotted = false)
                    ),
                    IntersectionPoint(
                        color = RedChart
                    ),
                    SelectionHighlightPoint(color = MaterialTheme.colorScheme.primary),
                    ShadowUnderLine(
                        alpha = 0.5f,
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                RedChart,
                                CardBackground
                            )
                        )
                    ),
                    SelectionHighlightPopUp()
                )
            ),
        ),
        backgroundColor = CardBackground,
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        gridLines = GridLines(color = MaterialTheme.colorScheme.outlineVariant)
    )

    LineChart(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),

        lineChartData = lineChartData

    )
}

@Composable
@Preview
fun PreviewLineChart() {
    WeightLineChart()
}
