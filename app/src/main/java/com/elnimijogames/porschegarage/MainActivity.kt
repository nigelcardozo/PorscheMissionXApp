package com.elnimijogames.porschegarage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.elnimijogames.porschegarage.ui.detailsscreen.DetailsScreen
import com.elnimijogames.porschegarage.ui.mainmenu.MainMenuScreen
import com.elnimijogames.porschegarage.ui.mainmenu.MainMenuViewModel
import com.elnimijogames.porschegarage.ui.splashscreen.SplashScreen
import com.elnimijogames.porschegarage.ui.theme.PorscheGarageTheme

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
            val viewModel: MainMenuViewModel = viewModel()
            //MealDetailsScreen(viewModel.mealState.value)
            MainMenuScreen(viewModel.photoGalleryState.value, viewModel.itemMenuState.value)
        }
        composable(route = "details_screen") {
            DetailsScreen()
        }
    }
}

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            PorscheGarageTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = StartScreenBackgroundColor
//                ) {
//                    Greeting("Android")
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier
//    .background(color = StartScreenBackgroundColor)
//    .fillMaxSize()) {
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Top,
//        modifier = Modifier
//            .padding(top = 100.dp)
//            .background(color = StartScreenBackgroundColor)) {
//
//        AsyncImage(
//            model = "file:///android_asset/images/porsche_logo.png",
//            //model = "file:///android_asset/profile_ellie.jpeg",
//            //model = "https://www.freepnglogos.com/uploads/porsche-logo-0.png",
//            contentDescription = "Porsche Logo",
//            modifier = Modifier
//            .size(300.dp)
//            .padding(4.dp)
//        )
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    PorscheGarageTheme {
//        Greeting("Android")
//    }
//}