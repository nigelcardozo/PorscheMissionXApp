package com.elnimijogames.porschegarage.model

import javax.inject.Inject

class MenuItemRepository @Inject constructor(val dataSource: MenuItemListLocal) {
    fun getMenuItemsList(): List<MenuItem> {
        return dataSource.getMenuItemsList()
    }
}