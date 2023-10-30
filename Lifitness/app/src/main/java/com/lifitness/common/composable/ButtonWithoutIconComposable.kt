import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonWithoutIconComposable(
    text: String,
    textColor: Color,
    fontSize: Int,
    minHeight: Int,
    buttonColor: Color,
    horizontalPadding: Int
) {
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(minHeight.dp)
            .padding(horizontal = horizontalPadding.dp),
        colors = ButtonDefaults.buttonColors(buttonColor),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(minHeight.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = textColor,
                fontSize = fontSize.sp,
                //Provisional
                fontWeight = FontWeight.Bold
            )
        }
    }
}
