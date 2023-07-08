package com.elnimijogames.porschegarage.ui.splashscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.elnimijogames.porschegarage.ui.theme.PorscheGarageTheme
import com.elnimijogames.porschegarage.ui.theme.StartButtonBackgroundColor

@Composable
fun SplashScreen(navigationCallback: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        WallPaper()
        StartButton(navigationCallback)
    }
}

@Composable
fun StartButton(navigationCallback: () -> Unit) {
    Button(
        onClick = {
            navigationCallback()
        },
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = StartButtonBackgroundColor
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 100.dp, start = 20.dp, end = 20.dp)
    ) {
        Text(text = "Start")
    }
}

@Composable
fun WallPaper() {
    AsyncImage(
        model = "file:///android_asset/images/porsche_splash_screen.jpg",
        contentDescription = "Porsche Wallpaper",
        contentScale = ContentScale.FillHeight,
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.9f)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PorscheGarageTheme {
        SplashScreen({})
    }
}