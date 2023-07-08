package com.elnimijogames.porschegarage.model

import javax.inject.Inject

class MenuItemRepository @Inject constructor(val dataSource: MenuItemListInterface) {
    fun getMenuItemsList(): List<MenuItem> {
        return dataSource.getMenuItemsList()
    }
}