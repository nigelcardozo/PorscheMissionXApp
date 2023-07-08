package com.elnimijogames.porschegarage.ui.mainmenu

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.elnimijogames.porschegarage.model.MenuItem
import com.elnimijogames.porschegarage.model.MenuItemRepository
import com.elnimijogames.porschegarage.model.MenuPhotoGalleryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainMenuViewModel @Inject constructor(
    galleryRepository: MenuPhotoGalleryRepository,
    menuItemRepository: MenuItemRepository
) : ViewModel() {
    val photoGalleryState: MutableState<List<String>> = mutableStateOf(emptyList())
    val itemMenuState: MutableState<List<MenuItem>> = mutableStateOf(emptyList())

    init {
        photoGalleryState.value = galleryRepository.getImageGalleryList()
        itemMenuState.value = menuItemRepository.getMenuItemsList()
    }
}