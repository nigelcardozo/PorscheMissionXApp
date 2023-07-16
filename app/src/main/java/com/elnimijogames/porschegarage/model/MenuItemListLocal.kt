package com.elnimijogames.porschegarage.model

import com.elnimijogames.porschegarage.R
import timber.log.Timber
import javax.inject.Inject

class MenuItemListLocal @Inject constructor(private val stringResourceProvider: StringResourceProvider): MenuItemListInterface {
    private val menuItemList = arrayListOf(
        getMenuItem(MenuId.MENU_ID_SUMMARY),
        getMenuItem(MenuId.MENU_ID_HIGHLIGHTS),
        getMenuItem(MenuId.MENU_ID_INTERIOR),
        getMenuItem(MenuId.MENU_ID_EXTERIOR),
        getMenuItem(MenuId.MENU_ID_EXPERIENCE),
        getMenuItem(MenuId.MENU_ID_TECHNOLOGY),
        getMenuItem(MenuId.MENU_ID_VIDEOS),
        getMenuItem(MenuId.MENU_ID_ABOUT)
    )

    override fun getMenuItemsList(): List<MenuItem> {
        return menuItemList
    }

    private fun getMenuItem(menuId: String): MenuItem = MenuItem(
        menuId = menuId,
        menuName = getMenuName(menuId),
        imagePath = getMenuImagePath(menuId)
    )

    private fun getMenuName(menuId: String): String {
        when (menuId) {
            MenuId.MENU_ID_SUMMARY -> return stringResourceProvider.getString(R.string.menu_details_title_summary, "")
            MenuId.MENU_ID_HIGHLIGHTS -> return stringResourceProvider.getString(R.string.menu_details_title_highlights, "")
            MenuId.MENU_ID_INTERIOR -> return stringResourceProvider.getString(R.string.menu_details_title_interior, "")
            MenuId.MENU_ID_EXTERIOR -> return stringResourceProvider.getString(R.string.menu_details_title_exterior, "")
            MenuId.MENU_ID_EXPERIENCE -> return stringResourceProvider.getString(R.string.menu_details_title_experience, "")
            MenuId.MENU_ID_TECHNOLOGY -> return stringResourceProvider.getString(R.string.menu_details_title_technology, "")
            MenuId.MENU_ID_VIDEOS -> return stringResourceProvider.getString(R.string.menu_details_title_videos, "")
            MenuId.MENU_ID_ABOUT -> return stringResourceProvider.getString(R.string.menu_details_title_about, "")
        }

        Timber.d("Illegal menuId value $menuId")
        return ""
    }

    private fun getMenuImagePath(menuId: String): String {
        when (menuId) {
            MenuId.MENU_ID_SUMMARY -> return "file:///android_asset/images/menu_outlines/summary.png"
            MenuId.MENU_ID_HIGHLIGHTS -> return "file:///android_asset/images/menu_outlines/highlights.png"
            MenuId.MENU_ID_INTERIOR -> return "file:///android_asset/images/menu_outlines/interior.png"
            MenuId.MENU_ID_EXTERIOR -> return "file:///android_asset/images/menu_outlines/exterior.png"
            MenuId.MENU_ID_EXPERIENCE -> return "file:///android_asset/images/menu_outlines/experience.png"
            MenuId.MENU_ID_TECHNOLOGY -> return "file:///android_asset/images/menu_outlines/technology.png"
            MenuId.MENU_ID_VIDEOS -> return "file:///android_asset/images/menu_outlines/videos.png"
            MenuId.MENU_ID_ABOUT -> return "file:///android_asset/images/menu_outlines/about.png"
        }

        Timber.d("Illegal menuId value $menuId")
        return ""
    }
}