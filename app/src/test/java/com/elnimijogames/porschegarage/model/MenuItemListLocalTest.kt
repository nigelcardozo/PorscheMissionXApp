package com.elnimijogames.porschegarage.model

import org.junit.Test

import org.junit.Assert.*

class MenuItemListLocalTest {

    @Test
    fun getMenuItemsList_returnsExpectedList() {
        val repository = MenuItemListLocal()

        val expectedMenuItemList = arrayListOf(
            MenuItem(
                imagePath = "file:///android_asset/images/menu/summary.png",
                menuName = "Summary",
                menuId = MenuId.MENU_ID_SUMMARY
            ),
            MenuItem(
                imagePath = "file:///android_asset/images/menu/highlights.png",
                menuName = "Highlights",
                menuId = MenuId.MENU_ID_HIGHLIGHTS
            ),
            MenuItem(
                imagePath = "file:///android_asset/images/menu/interior.png",
                menuName = "Interior",
                menuId = MenuId.MENU_ID_INTERIOR
            ),
            MenuItem(
                imagePath = "file:///android_asset/images/menu/exterior.png",
                menuName = "Exterior",
                menuId = MenuId.MENU_ID_EXTERIOR
            ),
            MenuItem(
                imagePath = "file:///android_asset/images/menu/driverexperience.png",
                menuName = "Experience",
                menuId = MenuId.MENU_ID_EXPERIENCE
            ),
            MenuItem(
                imagePath = "file:///android_asset/images/menu/technology.png",
                menuName = "Technology",
                menuId = MenuId.MENU_ID_TECHNOLOGY
            ),
            MenuItem(
                imagePath = "file:///android_asset/images/menu/videos.png",
                menuName = "Videos",
                menuId = MenuId.MENU_ID_VIDEOS
            ),
            MenuItem(
                imagePath = "file:///android_asset/images/menu/about.png",
                menuName = "About",
                menuId = MenuId.MENU_ID_ABOUT
            )
        )

        val result = repository.getMenuItemsList()

        assertEquals(expectedMenuItemList, result)
    }
}