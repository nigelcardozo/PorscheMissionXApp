package com.elnimijogames.porschegarage.model

import javax.inject.Inject

class MenuItemListLocal @Inject constructor(): MenuItemListInterface {
    val menuItemList = arrayListOf(
        MenuItem(
            imagePath = "file:///android_asset/images/menu_outlines/summary.png",
            menuName = "BooSummary",
            menuId = MenuId.MENU_ID_SUMMARY
        ),
        MenuItem(
            imagePath = "file:///android_asset/images/menu_outlines/highlights.png",
            menuName = "Highlights",
            menuId = MenuId.MENU_ID_HIGHLIGHTS
        ),
        MenuItem(
            imagePath = "file:///android_asset/images/menu_outlines/interior.png",
            menuName = "Interior",
            menuId = MenuId.MENU_ID_INTERIOR
        ),
        MenuItem(
            imagePath = "file:///android_asset/images/menu_outlines/exterior.png",
            menuName = "Exterior",
            menuId = MenuId.MENU_ID_EXTERIOR
        ),
        MenuItem(
            imagePath = "file:///android_asset/images/menu_outlines/experience.png",
            menuName = "Experience",
            menuId = MenuId.MENU_ID_EXPERIENCE
        ),
        MenuItem(
            imagePath = "file:///android_asset/images/menu_outlines/technology.png",
            menuName = "Technology",
            menuId = MenuId.MENU_ID_TECHNOLOGY
        ),
        MenuItem(
            imagePath = "file:///android_asset/images/menu_outlines/videos.png",
            menuName = "Videos",
            menuId = MenuId.MENU_ID_VIDEOS
        ),
        MenuItem(
            imagePath = "file:///android_asset/images/menu_outlines/about.png",
            menuName = "About",
            menuId = MenuId.MENU_ID_ABOUT
        )
    )

    override fun getMenuItemsList(): List<MenuItem> {
        return menuItemList
    }
}