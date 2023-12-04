package com.lifitness.screens.profile

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.lifitness.common.composable.DefaultButton
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import com.lifitness.common.composable.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.lifitness.R
import com.lifitness.app.LifitnessScreen
import com.lifitness.common.ext.endOfScreenSpacer
import com.lifitness.common.ext.spacer
import com.lifitness.model.createSingleMock
import com.lifitness.singleton.LoggedInUserSingleton
import com.lifitness.ui.theme.BackgroundColor
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Objects
import com.lifitness.ui.theme.BackgroundColor as background


fun Context.createImageFile(): File {
    val timeStamp = SimpleDateFormat("yyyy_MM_dd_HH:mm:ss").format(Date())
    val imageFileName = "JPEG_" + timeStamp + "_"
    val image = File.createTempFile(
        imageFileName,
        ".jpg",
        externalCacheDir
    )

    return image
}

@Composable
fun ProfileScreen(
    modifier: Modifier,
    navController: NavHostController
){
    val user = createSingleMock()
    val loading = true
    val profileViewModel = ProfileViewModel()
    val userSingleton = LoggedInUserSingleton.getInstance()
    val context = LocalContext.current
    val file = context.createImageFile()
    val uri = FileProvider.getUriForFile(
        Objects.requireNonNull(context),
        context.packageName + ".provider", file
    )
    var capturedImageUri by remember {
            mutableStateOf(Uri.EMPTY)
    }

    val cameraLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()){
            capturedImageUri = uri
        }

    val permissionLaucher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ){
        if(it){
            Toast.makeText(context, "Permissão obtida", Toast.LENGTH_SHORT).show()
            cameraLauncher.launch(uri)
        } else {
            Toast.makeText(context, "Permissão negada", Toast.LENGTH_SHORT).show()
        }
    }


    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
            .background(background),
        horizontalAlignment = Alignment.Start
        
    ){
        Row {
            MoreTitle()
        }
        Spacer(modifier = Modifier.spacer())
        Box {
            ImageBackground()
            Row (horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()){


                if (capturedImageUri.path?.isEmpty() == true){
                    val painter: Painter = rememberImagePainter(R.drawable.default_pfp)
                    ImageProfile(painter)
                } else {
                    val painter: Painter = rememberImagePainter(capturedImageUri)
                    ImageProfile(painter)
                }
                Button(onClick = {
                    val permissionCheckResult =
                        ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)
                    if (permissionCheckResult == PackageManager.PERMISSION_GRANTED){
                        cameraLauncher.launch(uri)
                    } else {
                        permissionLaucher.launch(Manifest.permission.CAMERA)
                    }
                }, colors = ButtonDefaults.buttonColors(Color.Transparent)) {
                    Icon(
                        Icons.Default.CameraAlt,
                        contentDescription = "Edit profile image",
                        tint = Color.White,
                    )
                }
            }

        }
        BioCard(
            nickname = userSingleton.username,
            content = userSingleton.bio
        )

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()) {
            SettingsTitle()
            Spacer(modifier = Modifier.spacer())
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DefaultButton(
                    contentTitle = "EDITAR PERFIL",
                    contentIcon = Icons.Default.Settings,
                    onClick = { navController.navigate(LifitnessScreen.Settings.name) },
                    buttonColor = BackgroundColor
                )
                Spacer(modifier = Modifier.spacer())
                DefaultButton(
                    contentTitle = "SAIR",
                    contentIcon = Icons.Default.ExitToApp,
                    onClick = {
                        userSingleton.resetUserData()
                        navController.navigate(LifitnessScreen.Login.name) },
                    buttonColor = BackgroundColor
                )
                Spacer(modifier = Modifier.spacer())
            }
        }

        Spacer(modifier = Modifier.endOfScreenSpacer())

    }
}

@Preview
@Composable
fun PreviewProfileScreen(){
    val navController = rememberNavController()
    ProfileScreen(modifier = Modifier, navController)
}