package com.lifitness.common.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lifitness.common.ext.spacer
import com.lifitness.common.ext.textButton
import com.lifitness.ui.theme.CardBackground
import com.lifitness.ui.theme.TextColor

@Composable
fun BioCard(content: String, nickname: String) {
    CardEditor(
        nickname = nickname,
        content = content,
    )
}

@Composable
fun CardEditor(
    nickname: String,
    content: String,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = CardBackground
        )
    ) {
        Spacer(modifier = Modifier.spacer())
        Text(
            text = nickname,
            color = TextColor,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(start = 16.dp)
        )
        Spacer(modifier = Modifier.spacer())
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()

        ) {
            if (content.isNotBlank()) {
                Text(
                    text = content,
                    color = TextColor,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(24.dp, 0.dp),
                )
            }
        }
        Spacer(modifier = Modifier.spacer())
    }
}

@Composable
@Preview
fun PreviewBioCard() {
    BioCard(

        "My story begins with the Lifitness app, which has been my trusty companion on this fitness adventure. I believe that age is just a number, and with the right tools and mindset, we can all live life to the fullest.",
        "Pedro Marcelo"
    )
}