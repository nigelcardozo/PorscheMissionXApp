package com.elnimijogames.porschegarage.ui.detailsscreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.elnimijogames.porschegarage.model.DetailsScreenRepository
import com.elnimijogames.porschegarage.model.MenuId
import com.elnimijogames.porschegarage.model.MenuItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    detailsScreenRepository: DetailsScreenRepository
) : ViewModel() {
    val detailsTitle: MutableState<String> = mutableStateOf("")
    val detailsText: MutableState<AnnotatedString> = mutableStateOf(buildAnnotatedString {})
    val detailsImagePath: MutableState<String> = mutableStateOf("")

    init {
        val menuId = savedStateHandle.get<String>("menuId")?: ""
        Timber.d("menuId == $menuId")

        detailsTitle.value = detailsScreenRepository.getDetailsTitle(menuId)
        detailsImagePath.value = detailsScreenRepository.getDetailsImagePath(menuId)
        detailsText.value = detailsScreenRepository.getDetailsTextDetails(menuId)
    }
}