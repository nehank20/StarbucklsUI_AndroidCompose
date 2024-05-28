package com.example.nehank.starbucksappui_androidcompose.screens

import android.window.SplashScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nehank.starbucksappui_androidcompose.R
import com.example.nehank.starbucksappui_androidcompose.common_components.CircularImageDrawable
import com.example.nehank.starbucksappui_androidcompose.ui.theme.*
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(modifier: Modifier = Modifier, navigateToNextScreen: () -> Unit) {

    LaunchedEffect(key1 = Unit) {
        delay(2000)
        navigateToNextScreen()
    }


    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White), contentAlignment = Alignment.Center) {
        CircularImageDrawable(icon = R.drawable.logo, size = 200.dp,)
    }
}
