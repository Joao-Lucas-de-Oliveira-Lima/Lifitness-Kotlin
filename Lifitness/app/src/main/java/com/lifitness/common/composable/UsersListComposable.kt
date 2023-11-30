package com.lifitness.common.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lifitness.R
import com.lifitness.app.LifitnessScreen
import com.lifitness.model.User
import com.lifitness.ui.theme.TextColor
import com.lifitness.model.createMock
import com.lifitness.ui.theme.BackgroundColor
import com.lifitness.ui.theme.CardBackground
import com.lifitness.ui.theme.RedChart

@Composable
fun UserList(users: List<User>, navController: NavHostController){
    LazyColumn(){
        items(users) {user ->
            Button(
                onClick = { navController.navigate(LifitnessScreen.PersonalClient.name)},
                colors = ButtonDefaults.buttonColors(CardBackground),
                shape = RoundedCornerShape(10),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .background(CardBackground)
                ) {
                    Image(
                        painter = painterResource(R.drawable.image_16),
                        contentDescription = "User profile picture",
                        modifier = Modifier
                            .size(70.dp)
                            .clip(CircleShape)
                            .padding(10.dp, 0.dp, 0.dp, 0.dp)
                    )
                    Text(text = user.nickname, color = TextColor, fontSize = 22.sp, modifier = Modifier.padding(20.dp, 0.dp))
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(Color.Transparent)) {
                        Icon(
                            Icons.Default.Delete,
                            contentDescription = "Delete train button",
                            tint = RedChart,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun UserListPreview(){
    val navController = rememberNavController()
    UserList(users = createMock(), navController)
}