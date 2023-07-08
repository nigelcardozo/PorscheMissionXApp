package com.elnimijogames.porschegarage.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
//class MenuItemRepository(private val dataSource: MenuItemListInterface) {
class MenuItemRepository @Inject constructor(val dataSource: MenuItemListLocal) {
    fun getMenuItemsList(): List<MenuItem> {
        return dataSource.getMenuItemsList()
    }
}