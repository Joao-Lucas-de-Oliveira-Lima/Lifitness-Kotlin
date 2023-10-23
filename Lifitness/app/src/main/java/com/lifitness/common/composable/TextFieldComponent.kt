package com.lifitness.common.composable

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonOutline
import androidx.compose.material.icons.filled.Preview
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.R.drawable.*
import com.lifitness.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(labelValue : String, imageVector : ImageVector){

    var textValue = remember{
        mutableStateOf("")
    }
    Row(){

        OutlinedTextField(
            modifier = Modifier
                .background(Color(35, 33, 33), RoundedCornerShape(12.dp)),
            label = {
                Text(text = labelValue, color = Color.White)},
            value = textValue.value,
            onValueChange = {
                textValue.value = it
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.White,
                focusedBorderColor = Color.White,
                focusedLabelColor = Color.White,
                cursorColor = Color.White,
            ),
            keyboardOptions = KeyboardOptions.Default,
            textStyle = androidx.compose.ui.text.TextStyle(color = Color.White),
            leadingIcon = {
                Icon(
                    imageVector,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextFieldComponent(labelValue : String, imageVector : ImageVector){
    var textValue = remember{
        mutableStateOf("")
    }
    var isPasswordVisible = remember{
        mutableStateOf(false)
    }
    val visualTransformation = if (isPasswordVisible.value) {
        VisualTransformation.None
    } else {
        PasswordVisualTransformation()
    }
    OutlinedTextField(
        modifier = Modifier
            .background(Color(35, 33, 33), RoundedCornerShape(12.dp)),
        label = {
            Text(text = labelValue, color = Color.White)
        },
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.White,
            focusedBorderColor = Color.White,
            focusedLabelColor = Color.White,
            cursorColor = Color.White,
        ),
        textStyle = TextStyle(color = Color.White),

        leadingIcon = {
            Icon(
                imageVector,
                contentDescription = "",
                tint = Color.White
            )
        },

        trailingIcon = {
            val IconImage = if(isPasswordVisible.value){
                Icons.Default.Visibility
            }else{
                Icons.Default.VisibilityOff
            }
            IconButton(onClick = { isPasswordVisible.value = !isPasswordVisible.value }) {
                Icon(
                    IconImage,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }

    )
}

@Preview
@Composable
fun PreviewTextFieldComponent(){
    TextFieldComponent(labelValue = "Preview", imageVector = Icons.Default.Preview)
}

@Preview
@Composable
fun PreviewPasswordTextFieldComponent(){
    PasswordTextFieldComponent(labelValue = "Preview", imageVector = Icons.Default.Lock);
}