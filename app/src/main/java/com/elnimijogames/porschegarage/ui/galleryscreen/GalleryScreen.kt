package com.elnimijogames.porschegarage.ui.galleryscreen

import androidx.compose.foundation.background
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
fun GalleryScreen(imagePath: String, navigateUpCallback: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        WallPaper(imagePath)
        StartButton(navigateUpCallback)
    }
}

@Composable
fun StartButton(navigateUpCallback: () -> Unit) {
    Button(
        onClick = {
            navigateUpCallback()
        },
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = StartButtonBackgroundColor
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp, start = 20.dp, end = 20.dp)
    ) {
        Text(text = "Back")
    }
}

@Composable
fun WallPaper(imagePath: String) {
    AsyncImage(
        model = imagePath,
        contentDescription = "Porsche Wallpaper",
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.9f)
            .background(Color.DarkGray)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PorscheGarageTheme {
        GalleryScreen("", {})
    }
}