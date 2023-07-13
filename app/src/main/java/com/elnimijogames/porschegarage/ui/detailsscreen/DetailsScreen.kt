package com.elnimijogames.porschegarage.ui.detailsscreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun DetailsScreen(detailsTitle: String, detailsImagePath: String, detailsText: AnnotatedString) {
    val lazyListState = rememberLazyListState()
    var scrolledY = 0f
    var previousOffset = 0
    LazyColumn(
        Modifier.fillMaxSize(),
        lazyListState,
    ) {
        item {
            AsyncImage(
                model = detailsImagePath,
                contentDescription = "Header Image",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    //.align(Alignment.CenterHorizontally)
                    .alpha(0.9f)
                    .graphicsLayer {
                        scrolledY += lazyListState.firstVisibleItemScrollOffset - previousOffset
                        translationY = scrolledY * 0.5f
                        previousOffset = lazyListState.firstVisibleItemScrollOffset
                    }
                    .height(240.dp)
                    .fillMaxWidth()
            )
        }
        item {
            Text(
                text = detailsTitle,
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier.padding(10.dp)
            )
        }
        item {
            Text(
                text = detailsText,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}