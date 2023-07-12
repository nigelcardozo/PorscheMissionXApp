package com.elnimijogames.porschegarage.model

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class MenuItemRepositoryTest {

    @Mock
    private lateinit var dataSource: MenuItemListInterface

    private lateinit var repository: MenuItemRepository

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        repository = MenuItemRepository(dataSource)
    }

    @Test
    fun getMenuItemsList_returnsExpectedList() {
        val expectedList = listOf(
            MenuItem("file://some/path/item1.jpg", "Menu Item 1", "MENU_ITEM_1"),
            MenuItem("file://some/path/item2.jpg", "Menu Item 2", "MENU_ITEM_2"),
            MenuItem("file://some/path/item3.jpg", "Menu Item 3", "MENU_ITEM_3")
        )

        `when`(dataSource.getMenuItemsList()).thenReturn(expectedList)

        val result = repository.getMenuItemsList()

        assertEquals(expectedList, result)
    }

    @Test
    fun getMenuItemsList_callsDataSourceMethod() {
        val expectedList = listOf(
            MenuItem("file://some/path/item1.jpg", "Menu Item 1","MENU_ITEM_1"),
            MenuItem("file://some/path/item2.jpg", "Menu Item 2","MENU_ITEM_2"),
            MenuItem("file://some/path/item3.jpg", "Menu Item 3","MENU_ITEM_3")
        )

        `when`(dataSource.getMenuItemsList()).thenReturn(expectedList)

        repository.getMenuItemsList()

        verify(dataSource).getMenuItemsList()
    }
}