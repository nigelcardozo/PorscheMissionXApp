package com.elnimijogames.porschegarage

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.elnimijogames.porschegarage.ui.splashscreen.SplashScreen
import com.elnimijogames.porschegarage.ui.theme.PorscheGarageTheme
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SplashScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun clickStartButton_navigatesToNextScreen() {
        // Launch the Composable function with the navigation callback
        composeTestRule.setContent {
            SplashScreen(navigationCallback = {})
        }

        // Assert that the SplashScreen is displayed
        composeTestRule.onNodeWithText("Start").assertIsDisplayed()

    }

    @Test
    fun testSplashScreen_wallpaperDisplayed() {

        composeTestRule.setContent {
            PorscheGarageTheme {
                SplashScreen(navigationCallback = {})
            }
        }

        // Assert that the Wallpaper is displayed
        composeTestRule.onNodeWithContentDescription("Porsche Wallpaper")
            .assertIsDisplayed()
    }

    @Test
    fun testSplashScreen_startButtonClicked_navigationCallbackInvoked() {
        var navigationCallbackInvoked = false

        // Launch the Composable function with the navigation callback
        composeTestRule.setContent {
            PorscheGarageTheme {
                SplashScreen(navigationCallback = {
                    navigationCallbackInvoked = true
                })
            }
        }

        composeTestRule.onNodeWithText("Start").performClick()

        // Assert that the navigation callback was invoked
        assertTrue(navigationCallbackInvoked)
    }
}