package com.example.lifitness.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import com.example.lifitness.common.composable.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.lifitness.common.ext.spacer

@Composable
fun ProfileScreen(
    modifier: Modifier
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
        
    ){
        MoreTitle()
        ImageProfile()
        Spacer(modifier = Modifier.spacer())
        ImageBackground()
        BioCard(content = "TESTE")
    }
}

@Preview
@Composable
fun PreviewProfileScreen(){
    ProfileScreen(modifier = Modifier)
}