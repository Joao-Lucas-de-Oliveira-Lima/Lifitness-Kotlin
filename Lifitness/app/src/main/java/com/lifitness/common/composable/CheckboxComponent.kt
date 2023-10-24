package com.lifitness.common.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CheckboxComponent(text : String){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 10.dp)
            .padding(horizontal = 50.dp),
        verticalAlignment = Alignment.CenterVertically,
    ){
        var isChecked = remember {
            mutableStateOf(false)
        }
        Checkbox(checked = isChecked.value, onCheckedChange = {
            isChecked.value = !isChecked.value
        })
        ClickablePolicyTextAndTermsTextComponent(text)
    }
}
