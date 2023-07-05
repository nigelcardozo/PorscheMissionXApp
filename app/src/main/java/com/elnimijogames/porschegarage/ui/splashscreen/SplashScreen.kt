package com.elnimijogames.porschegarage.ui.splashscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.elnimijogames.porschegarage.ui.theme.MissionXTextGradientEnd
import com.elnimijogames.porschegarage.ui.theme.MissionXTextGradientStart
import com.elnimijogames.porschegarage.ui.theme.PorscheGarageTheme
import com.elnimijogames.porschegarage.ui.theme.SplashScreenBackgroundColorGradientEnd
import com.elnimijogames.porschegarage.ui.theme.SplashScreenBackgroundColorGradientStart

@Composable
fun SplashScreen(navigationCallback: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        SplashScreenBackgroundColorGradientStart,
                        SplashScreenBackgroundColorGradientEnd
                    )
                )
            )
            .padding(top = 100.dp)) {

        PorscheLogo(navigationCallback)
        MissionXText()
    }
}

@Composable
fun PorscheLogo(navigationCallback: () -> Unit) {
    AsyncImage(
        model = "file:///android_asset/images/porsche_logo.png",
        contentDescription = "Porsche Logo",
        modifier = Modifier
            .size(300.dp)
            .padding(4.dp)
            .clickable { navigationCallback() }
    )
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun MissionXText() {
    val gradientColors = listOf(MissionXTextGradientStart, MissionXTextGradientEnd)

    Text(
        text = "Mission X",
        style = TextStyle(
            fontStyle = MaterialTheme.typography.displayLarge.fontStyle,
            fontFamily = MaterialTheme.typography.displayLarge.fontFamily,
            fontWeight = MaterialTheme.typography.displayLarge.fontWeight,
            fontSize = MaterialTheme.typography.displayLarge.fontSize,
            lineHeight = MaterialTheme.typography.displayLarge.lineHeight,
            letterSpacing = MaterialTheme.typography.displayLarge.letterSpacing,
            brush = Brush.linearGradient(
                colors = gradientColors
            )
        )
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PorscheGarageTheme {
        SplashScreen({})
    }
}