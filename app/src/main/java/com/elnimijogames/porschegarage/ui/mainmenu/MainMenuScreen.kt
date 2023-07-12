package com.elnimijogames.porschegarage.ui.mainmenu

import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
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

@Composable
fun MainMenuScreen(imageGalleryPaths: List<String>, menuItemList: List<MenuItem>, navigationCallback: (String) -> Unit) {
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
        HorizontalImageGallery(assetPaths = imageGalleryPaths)
        VerticalGridButtons(menuItems = menuItemList)
    }
}

@Composable
fun HorizontalImageGallery(assetPaths: List<String>) {
    LazyRow(modifier = Modifier.height(160.dp)) {
        items(assetPaths) { assetPath ->
            GalleryCard(assetPath)
        }
    }
}

@Composable
fun VerticalGridButtons(menuItems: List<MenuItem>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(menuItems) { menuItem ->
            MenuItem(menuItem)
        }
    }
}

@Composable
fun GalleryCard(model: String) {
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
        )
    }
}

@Composable
fun MenuItem(menuItem: MenuItem) {
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
        )

        Text(modifier = Modifier
            .align(CenterHorizontally)
            .padding(bottom = 5.dp),
            text = menuItem.menuName,
            style = MaterialTheme.typography.headlineLarge
        )
    }
}

//@Composable
//fun MenuCard(model: String) {
//    Card(modifier = Modifier
//        .padding(start = 0.dp, top = 5.dp, end = 0.dp, bottom = 5.dp)
//        .wrapContentWidth(align = Alignment.CenterHorizontally)
//        .wrapContentHeight(align = Alignment.CenterVertically),
//        //.clickable { clickAction.invoke() },
//        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
//    ) {
//        AsyncImage(
//            model = model,
//            contentDescription = "Porsche Logo",
//            modifier = Modifier
//                //.background(MainMenuMenuCardBackgroundColor.copy(alpha = 0.4f))
//                .width(180.dp)
//                .height(180.dp)
//                .alpha(0.7f)
//        )
//
//        Spacer(Modifier.height(10.dp))
//
//        Text(modifier = Modifier
//            .align(CenterHorizontally)
//            .padding(bottom = 10.dp),
//            text ="Hello",
//            style = TextStyle(
//                fontStyle = MaterialTheme.typography.displayLarge.fontStyle,
//                fontFamily = MaterialTheme.typography.displayLarge.fontFamily,
//                fontWeight = MaterialTheme.typography.displayLarge.fontWeight,
//                fontSize = 24.sp,
//                lineHeight = MaterialTheme.typography.displayLarge.lineHeight,
//                letterSpacing = MaterialTheme.typography.displayLarge.letterSpacing,
//            )
//        )
//    }
//}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PorscheGarageTheme {
        MainMenuScreen(listOf(), MenuItemListLocal().menuItemList, {})
    }
}