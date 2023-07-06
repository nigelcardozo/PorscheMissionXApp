package com.elnimijogames.porschegarage.model

class MenuItemRepository(private val dataSource: MenuItemListInterface) {
    fun getMenuItemsList(): List<MenuItem> {
        return dataSource.getMenuItemsList()
    }

    // This is temporary until we have DI in place
//    companion object {
//        @Volatile
//        private var instance: MenuItemRepository? = null
//
//        fun getInstance() = instance?: synchronized(this) {
//            instance ?: MenuItemRepository().also { instance = it }
//        }
//    }
}