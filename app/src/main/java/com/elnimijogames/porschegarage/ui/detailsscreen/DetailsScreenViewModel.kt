package com.elnimijogames.porschegarage.ui.detailsscreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.elnimijogames.porschegarage.model.DetailItem
import com.elnimijogames.porschegarage.model.MenuId
import com.elnimijogames.porschegarage.model.MenuItem
import com.elnimijogames.porschegarage.model.MenuItemRepository
import com.elnimijogames.porschegarage.model.MenuPhotoGalleryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    val detailsText: MutableState<String> = mutableStateOf("")
    val detailsImagePath: MutableState<String> = mutableStateOf("")

    init {
        val menuId = savedStateHandle.get<String>("menuId")?: ""

        Timber.d("menuId == $menuId")

        if (MenuId.MENU_ID_SUMMARY == menuId) {
            detailsText.value = "SUMMARY"
            Timber.d("detailsText set to SUMMARY")
        } else if (MenuId.MENU_ID_HIGHLIGHTS == menuId) {
            detailsText.value = "HIGHLIGHTS"
            Timber.d("detailsText set to HIGHLIGHTS")
        } else {
            Timber.d("detailsText not set")
        }
    }
}