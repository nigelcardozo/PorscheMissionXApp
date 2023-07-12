package com.elnimijogames.porschegarage.ui.detailsscreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import timber.log.Timber

@Composable
fun DetailsScreen(detailsImagePath: String, detailsText: String) {
    Timber.d("DetailsText == $detailsText")
    Text("You clicked $detailsText")
}