package com.elnimijogames.porschegarage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.elnimijogames.porschegarage.ui.detailsscreen.DetailsScreen
import com.elnimijogames.porschegarage.ui.mainmenu.MainMenuScreen
import com.elnimijogames.porschegarage.ui.mainmenu.MainMenuViewModel
import com.elnimijogames.porschegarage.ui.splashscreen.SplashScreen
import com.elnimijogames.porschegarage.ui.theme.PorscheGarageTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PorscheGarageTheme {
                PorscheGarageApp()
            }
        }
    }
}

@Composable
private fun PorscheGarageApp() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "destination_meals_list") {
        composable(route = "destination_meals_list") {
            SplashScreen {
                navController.navigate("main_menu_screen")
            }
        }
        composable(route = "main_menu_screen") {
            val viewModel: MainMenuViewModel = hiltViewModel()
            MainMenuScreen(viewModel.photoGalleryState.value, viewModel.itemMenuState.value)
        }
        composable(route = "details_screen") {
            DetailsScreen()
        }
    }
}