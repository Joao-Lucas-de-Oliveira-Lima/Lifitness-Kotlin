package com.lifitness.common.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun CheckboxComposable(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 10.dp)
            .padding(horizontal = 50.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        var isChecked = remember {
            mutableStateOf(false)
        }
        Checkbox(checked = isChecked.value, onCheckedChange = {
            isChecked.value = !isChecked.value
        })
        ClickablePolicyTextAndTermsTextComponent(text)
    }
}
