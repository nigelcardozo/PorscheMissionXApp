package com.elnimijogames.porschegarage.model

class MenuItemRepository {
    fun getMenuItemsList(): List<MenuItem> {
        return MenuItemList().menuItemList
    }

    // This is temporary until we have DI in place
    companion object {
        @Volatile
        private var instance: MenuItemRepository? = null

        fun getInstance() = instance?: synchronized(this) {
            instance ?: MenuItemRepository().also { instance = it }
        }
    }
}