package com.elnimijogames.porschegarage.ui.mainmenu

import com.elnimijogames.porschegarage.model.MenuItem
import com.elnimijogames.porschegarage.model.MenuItemRepository
import com.elnimijogames.porschegarage.model.MenuPhotoGalleryRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MainMenuViewModelTest {

    @RelaxedMockK
    private lateinit var galleryRepository: MenuPhotoGalleryRepository

    @RelaxedMockK
    private lateinit var menuItemRepository: MenuItemRepository

    private lateinit var viewModel: MainMenuViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        viewModel = MainMenuViewModel(galleryRepository, menuItemRepository)
    }

    @Test
    fun testMainMenuViewModel() {
        // Prepare mock data
        val galleryList = listOf("image1.jpg", "image2.jpg")
        val menuList = listOf(MenuItem("file://some/file/name1.jpg", "1", "MENU_ITEM_1"), MenuItem("file://some/file/name2.jpg", "2", "MENU_ITEM_2"))

        // Mock repository methods
        every { galleryRepository.getImageGalleryList() } returns galleryList
        every { menuItemRepository.getMenuItemsList() } returns menuList

        // create view model after defining actions of mock
        viewModel = MainMenuViewModel(galleryRepository, menuItemRepository)

        // Verify the initial state of the view model
        assertEquals(galleryList, viewModel.photoGalleryState.value)
        assertEquals(menuList, viewModel.itemMenuState.value)
    }
}