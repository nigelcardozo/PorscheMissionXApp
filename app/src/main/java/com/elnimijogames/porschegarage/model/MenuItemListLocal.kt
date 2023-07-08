package com.elnimijogames.porschegarage.model

import javax.inject.Inject

class MenuItemListLocal @Inject constructor(): MenuItemListInterface {
    val menuItemList = arrayListOf(
        MenuItem(
            imagePath = "file:///android_asset/images/menu/summary.png",
            menuName = "Summary"
        ),
        MenuItem(
            imagePath = "file:///android_asset/images/menu/highlights.png",
            menuName = "Highlights"
        ),
        MenuItem(
            imagePath = "file:///android_asset/images/menu/interior.png",
            menuName = "Interior"
        ),
        MenuItem(
            imagePath = "file:///android_asset/images/menu/exterior.png",
            menuName = "Exterior"
        ),
        MenuItem(
            imagePath = "file:///android_asset/images/menu/driverexperience.png",
            menuName = "Experience"
        ),
        MenuItem(
            imagePath = "file:///android_asset/images/menu/technology.png",
            menuName = "Technology"
        ),
        MenuItem(
            imagePath = "file:///android_asset/images/menu/videos.png",
            menuName = "Videos"
        ),
        MenuItem(
            imagePath = "file:///android_asset/images/menu/about.png",
            menuName = "About"
        )
    )

    override fun getMenuItemsList(): List<MenuItem> {
        return menuItemList
    }
}