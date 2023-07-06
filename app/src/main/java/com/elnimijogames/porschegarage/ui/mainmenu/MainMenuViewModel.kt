package com.elnimijogames.porschegarage.ui.mainmenu

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.elnimijogames.porschegarage.model.MenuItem
import com.elnimijogames.porschegarage.model.MenuItemRepository
import com.elnimijogames.porschegarage.model.MenuPhotoGalleryRepository

class MainMenuViewModel: ViewModel() {
    private val galleryRepository: MenuPhotoGalleryRepository = MenuPhotoGalleryRepository.getInstance()
    private val menuItemRepository: MenuItemRepository = MenuItemRepository.getInstance()

    val photoGalleryState: MutableState<List<String>> = mutableStateOf(emptyList())
    val itemMenuState: MutableState<List<MenuItem>> = mutableStateOf(emptyList())

    init {
        photoGalleryState.value = galleryRepository.getImageGalleryList()
        itemMenuState.value = menuItemRepository.getMenuItemsList()
    }
}