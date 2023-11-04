package com.lifitness.common.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lifitness.R
import com.lifitness.model.User
import com.lifitness.ui.theme.TextColor
import com.lifitness.model.createMock

@Composable
fun UserList(users: List<User>){
    LazyColumn(){
        items(users) {user ->
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(10.dp, 5.dp)
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.image_16),
                    contentDescription = "User profile picture",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                )
                Text(text = user.nickname, color = TextColor, fontSize = 20.sp, modifier = Modifier.padding(10.dp, 0.dp))
            }
        }
    }
}

@Preview
@Composable
fun UserListPreview(){
    UserList(users = createMock())
}