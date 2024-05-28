package com.example.nehank.starbucksappui_androidcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nehank.starbucksappui_androidcompose.screens.DetailScreen
import com.example.nehank.starbucksappui_androidcompose.screens.HomeScreen
import com.example.nehank.starbucksappui_androidcompose.screens.SplashScreen

@Composable
fun MainNavigation(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {

        composable(Screen.SplashScreen.route){
            SplashScreen{
                navController.navigate(Screen.HomeScreen.route)
            }
        }

        composable(Screen.HomeScreen.route){
            HomeScreen{
                navController.navigate(Screen.DetailScreen.route)
            }
        }

        composable(Screen.DetailScreen.route){
            DetailScreen()
        }

    }
}

sealed class Screen (val route : String) {
    data object SplashScreen : Screen("splashscreen")
    data object HomeScreen : Screen("homescreen")
    data object DetailScreen : Screen("detailscreen")
}
