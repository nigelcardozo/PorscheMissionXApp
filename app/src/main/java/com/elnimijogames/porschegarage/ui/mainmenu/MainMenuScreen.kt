package com.elnimijogames.porschegarage.ui.mainmenu

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.elnimijogames.porschegarage.model.MenuItem
import com.elnimijogames.porschegarage.model.MenuItemListLocal
import com.elnimijogames.porschegarage.ui.theme.MainMenuScreenBackgroundColorGradientEnd
import com.elnimijogames.porschegarage.ui.theme.MainMenuScreenBackgroundColorGradientStart
import com.elnimijogames.porschegarage.ui.theme.PorscheGarageTheme
import timber.log.Timber

@Composable
fun MainMenuScreen(
    imageGalleryPaths: List<String>,
    menuItemList: List<MenuItem>,
    navigationDetailsCallback: (String) -> Unit,
    navigationGalleryCallback: (String) -> Unit)
{
    Column(
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
        HorizontalImageGallery(assetPaths = imageGalleryPaths, navigationGalleryCallback)
        VerticalGridButtons(menuItems = menuItemList, navigationDetailsCallback)
    }
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
fun VerticalGridButtons(menuItems: List<MenuItem>, navigationCallback: (String) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(menuItems) { menuItem ->
            MenuItemTile(menuItem, navigationCallback)
        }
    }
}

@Composable
fun GalleryCard(model: String, navigationGalleryCallback: (String) -> Unit) {
    Card(modifier = Modifier
        .padding(start = 0.dp, top = 10.dp, end = 10.dp, bottom = 10.dp)
        .fillMaxSize(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        AsyncImage(
            model = model,
            contentDescription = "Porsche Gallery Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(150.dp)
                .padding(4.dp)
                .clickable ( onClick = {
                    Timber.d("Path == $model")
                    navigationGalleryCallback(Uri.encode(model))
                }
            )
        )
    }
}

@Composable
fun MenuItemTile(menuItem: MenuItem, navigationCallback:(String) -> Unit) {
    Column(
        Modifier
            .padding(10.dp)
            .background(Color.White.copy(alpha = 0.2f)),) {
        AsyncImage(
            model = menuItem.imagePath,
            contentDescription = "Menu Icon",
            modifier = Modifier
                .size(100.dp)
                .padding(top = 10.dp)
                .align(CenterHorizontally)
                .alpha(0.7f)
                .clickable ( onClick = {
                    Timber.d("menuItem clicked == " + menuItem.menuId)
                    navigationCallback(menuItem.menuId)
                }
            )
        )

        Text(modifier = Modifier
            .align(CenterHorizontally)
            .padding(bottom = 5.dp),
            text = menuItem.menuName,
            style = MaterialTheme.typography.headlineLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PorscheGarageTheme {
        MainMenuScreen(listOf(), MenuItemListLocal().menuItemList, {}, {})
    }
}