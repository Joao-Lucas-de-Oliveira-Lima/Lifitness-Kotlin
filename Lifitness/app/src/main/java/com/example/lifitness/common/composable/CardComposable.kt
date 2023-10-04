package com.example.lifitness.common.composable

import com.example.lifitness.ui.theme.cardBackground
import com.example.lifitness.ui.theme.textColor
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lifitness.common.ext.textButton

@Composable
fun BioCard(
    content: String,
) {
    CardEditor(
        content = content ,
        modifier = Modifier.textButton()
    )
}

@Composable
private fun CardEditor(
    content: String,
    modifier: Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = cardBackground
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)

        ) {
            if (content.isNotBlank()) {
                Text(text = content, color = textColor, fontFamily = FontFamily.SansSerif, modifier = Modifier.padding(16.dp, 0.dp))
            }
        }
    }
}

@Composable
@Preview
fun PreviewBioCard(){
    BioCard(
        "My story begins with the Lifitness app, which has been my trusty companion on this fitness adventure. I believe that age is just a number, and with the right tools and mindset, we can all live life to the fullest.",
    )
}