package com.elnimijogames.porschegarage.ui.mainmenu

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.elnimijogames.porschegarage.model.MenuItem
import com.elnimijogames.porschegarage.ui.theme.MainMenuScreenBackgroundColorGradientEnd
import com.elnimijogames.porschegarage.ui.theme.MainMenuScreenBackgroundColorGradientStart
import com.elnimijogames.porschegarage.ui.theme.MainMenuTileBackgroundColor
import com.elnimijogames.porschegarage.ui.theme.MainMenuTileBorderColor
import timber.log.Timber


@Composable
fun MainMenuScreen(
    imageGalleryPaths: List<String>,
    menuItemList: List<MenuItem>,
    navigationDetailsCallback: (String) -> Unit,
    navigationGalleryCallback: (String) -> Unit)
{
    VerticalGridButtons(
        menuItems = menuItemList,
        navigationDetailsCallback,
        imageGalleryPaths,
        navigationGalleryCallback
    )
}

@Composable
fun HorizontalImageGallery(assetPaths: List<String>, navigationGalleryCallback: (String) -> Unit) {
    LazyRow(modifier = Modifier.height(160.dp)) {
        items(assetPaths) { assetPath ->
            GalleryCard(assetPath, navigationGalleryCallback)
        }
    }
}

@Composable
fun VerticalGridButtons(
    menuItems: List<MenuItem>,
    navigationCallback: (String) -> Unit,
    assetPaths: List<String>,
    navigationGalleryCallback: (String) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MainMenuScreenBackgroundColorGradientStart,
                        MainMenuScreenBackgroundColorGradientEnd
                    )
                )
            )
    ) {
        item(
            span = {
                GridItemSpan(maxLineSpan)
            },
        ) {
            HorizontalImageGallery(assetPaths, navigationGalleryCallback)
        }
        items(menuItems) { menuItem ->
            MenuItemTile(menuItem, navigationCallback)
        }
    }
}

@Composable
fun GalleryCard(model: String, navigationGalleryCallback: (String) -> Unit) {
    Card(
        modifier = Modifier
            .padding(start = 0.dp, top = 10.dp, end = 10.dp, bottom = 10.dp)
            .fillMaxSize(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = MainMenuTileBorderColor)
    ) {
        AsyncImage(
            alignment = Alignment.Center,
            model = model,
            contentDescription = "Porsche Gallery Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(150.dp)
                .padding(4.dp)
                .clickable(onClick = {
                    Timber.d("Path == $model")
                    navigationGalleryCallback(Uri.encode(model))
                })
        )
    }
}

@Composable
fun MenuItemTile(menuItem: MenuItem, navigationCallback:(String) -> Unit) {
    Card(
        Modifier
            .padding(10.dp)
            .background(Color.Black.copy(alpha = 0.8f)),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        colors = CardDefaults.cardColors(containerColor = MainMenuTileBorderColor)
    ) {
        Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(5.dp)
            .background(color = MainMenuTileBackgroundColor.copy(alpha = 0.9f))
            //.background(color = Color.Gray)
            .fillMaxWidth(),
        ) {
            AsyncImage(
                model = menuItem.imagePath,
                contentDescription = "Menu Icon",
                modifier = Modifier
                    .size(90.dp)
                    .padding(top = 10.dp)
                    .align(CenterHorizontally)
                    .clickable(onClick = {
                        Timber.d("menuItem clicked == " + menuItem.menuId)
                        navigationCallback(menuItem.menuId)
                    }
                )
            )

            Spacer(modifier = Modifier.height(height = 15.dp))

            Text(modifier = Modifier
                .align(CenterHorizontally)
                .padding(bottom = 5.dp),
                text = menuItem.menuName,
                style = MaterialTheme.typography.displayMedium,
                color = Color.White
            )
        }
    }
}