package com.elnimijogames.porschegarage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.elnimijogames.porschegarage.ui.detailsscreen.DetailsScreen
import com.elnimijogames.porschegarage.ui.detailsscreen.DetailsScreenViewModel
import com.elnimijogames.porschegarage.ui.mainmenu.MainMenuScreen
import com.elnimijogames.porschegarage.ui.mainmenu.MainMenuViewModel
import com.elnimijogames.porschegarage.ui.splashscreen.SplashScreen
import com.elnimijogames.porschegarage.ui.theme.PorscheGarageTheme
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

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

    NavHost(navController, startDestination = "splash_screen") {
        composable(route = "splash_screen") {
            SplashScreen {
                navController.navigate("main_menu_screen")
            }
        }
        composable(route = "main_menu_screen") {
            val viewModel: MainMenuViewModel = hiltViewModel()
            MainMenuScreen(
                viewModel.photoGalleryState.value,
                viewModel.itemMenuState.value) { menuId ->
                navController.navigate("details_screen/$menuId")
            }
        }
        composable(
            route = "details_screen/{menuId}",
            arguments = listOf (navArgument("menuId") {
                type = NavType.StringType
            })
        ) {
            val viewModel: DetailsScreenViewModel = hiltViewModel()
            Timber.d("detailsText v1 == " + viewModel.detailsText.value)
            DetailsScreen(viewModel.detailsImagePath.value, viewModel.detailsText.value)
        }
    }
}