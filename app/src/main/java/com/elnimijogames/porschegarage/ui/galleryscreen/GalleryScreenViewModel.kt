package com.elnimijogames.porschegarage.ui.galleryscreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GalleryScreenViewModel @Inject constructor(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    val detailsImagePath: MutableState<String> = mutableStateOf("")

    init {
        detailsImagePath.value = savedStateHandle.get<String>("galleryPath")?: ""
    }
}