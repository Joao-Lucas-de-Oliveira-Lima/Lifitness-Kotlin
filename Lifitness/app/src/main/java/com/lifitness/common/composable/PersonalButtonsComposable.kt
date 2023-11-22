package com.lifitness.common.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ManageAccounts
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lifitness.ui.theme.CardBackground

@Composable
fun PersonalButton(contentTitle: String, contentIcon: ImageVector, onClick: () -> Unit){
    Button(
        onClick = onClick,
        border = BorderStroke(1.dp, Color.Gray),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = CardBackground),
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
            Icon(
                contentIcon,
                contentDescription = contentTitle,
                tint = Color.White,
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(40.dp)
            )
            Text(text=contentTitle, fontSize = 20.sp)
        }
    }
}

@Preview
@Composable
fun PreviewPersonalButton(){
    PersonalButton("MANAGE STUDENTS", Icons.Default.ManageAccounts, onClick = ({}) )
}