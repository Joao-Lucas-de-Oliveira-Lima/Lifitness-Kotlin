import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.KeyboardArrowRight
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
import com.example.lifitness.ui.theme.ButtonColorPerfil
import com.example.lifitness.ui.theme.CardGreen

@Composable
fun DefaultButton(
    contentTitle: String,
    contentIcon: ImageVector, // Pass the icon as an ImageVector
    onClick: () -> Unit,
    buttonColor: Color
) {
    Button(
        onClick = { onClick() },
        modifier = Modifier
                    .fillMaxWidth()
                    .height(85.dp),
        shape = RoundedCornerShape(10),
        border = BorderStroke(1.dp, Color.Gray),
        colors = ButtonDefaults.buttonColors(buttonColor)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    imageVector = contentIcon, // Use the provided ImageVector for the icon
                    contentDescription = null, // Set contentDescription as needed for accessibility
                    modifier = Modifier.padding(end = 4.dp) // Add spacing between icon and text
                )
                Text(text = contentTitle)
            }
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null, // Set contentDescription as needed for accessibility
                modifier = Modifier.padding(end = 4.dp) // Add spacing between icon and text
            )
        }
    }
}


@Composable
@Preview
fun PreviewButton(){

    DefaultButton(
        contentIcon = Icons.Default.ExitToApp,
        contentTitle = "LogOut",
        onClick = {
            // Your button click logic here
        },
        buttonColor = ButtonColorPerfil
    )
}