package com.elnimijogames.porschegarage.model

import android.content.Context
import android.content.res.Resources
import com.elnimijogames.porschegarage.R
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.MockitoAnnotations

class MenuItemListLocalTest {

    val mockContext = mockk<Context>(relaxed = true)
    val mockResources = mockk<Resources>(relaxed = true)

    @RelaxedMockK
    private lateinit var stringResourceProvider: StringResourceProvider

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        stringResourceProvider = StringResourceProviderImpl(mockResources)
    }

    @Test
    fun getMenuItemsList_returnsExpectedList() {
        // Mock repository methods
        every { mockContext.getString(R.string.menu_details_title_summary, "")} returns "Summary"
        every { stringResourceProvider.getString(R.string.menu_details_title_summary, "") } returns "Summary"
        every { mockContext.getString(R.string.menu_details_title_highlights, "")} returns "Highlights"
        every { stringResourceProvider.getString(R.string.menu_details_title_highlights, "") } returns "Highlights"
        every { mockContext.getString(R.string.menu_details_title_interior, "")} returns "Interior"
        every { stringResourceProvider.getString(R.string.menu_details_title_interior, "") } returns "Interior"
        every { mockContext.getString(R.string.menu_details_title_exterior, "")} returns "Exterior"
        every { stringResourceProvider.getString(R.string.menu_details_title_exterior, "") } returns "Exterior"

        every { mockContext.getString(R.string.menu_details_title_technology, "")} returns "Technology"
        every { stringResourceProvider.getString(R.string.menu_details_title_technology, "") } returns "Technology"
        every { mockContext.getString(R.string.menu_details_title_experience, "")} returns "Experience"
        every { stringResourceProvider.getString(R.string.menu_details_title_experience, "") } returns "Experience"
        every { mockContext.getString(R.string.menu_details_title_videos, "")} returns "Videos"
        every { stringResourceProvider.getString(R.string.menu_details_title_videos, "") } returns "Videos"
        every { mockContext.getString(R.string.menu_details_title_about, "")} returns "About"
        every { stringResourceProvider.getString(R.string.menu_details_title_about, "") } returns "About"

        val repository = MenuItemListLocal(stringResourceProvider)

        val expectedMenuItemList = arrayListOf(
            MenuItem(
                imagePath = "file:///android_asset/images/menu_outlines/summary.png",
                menuName = "Summary",
                menuId = MenuId.MENU_ID_SUMMARY
            ),
            MenuItem(
                imagePath = "file:///android_asset/images/menu_outlines/highlights.png",
                menuName = "Highlights",
                menuId = MenuId.MENU_ID_HIGHLIGHTS
            ),
            MenuItem(
                imagePath = "file:///android_asset/images/menu_outlines/interior.png",
                menuName = "Interior",
                menuId = MenuId.MENU_ID_INTERIOR
            ),
            MenuItem(
                imagePath = "file:///android_asset/images/menu_outlines/exterior.png",
                menuName = "Exterior",
                menuId = MenuId.MENU_ID_EXTERIOR
            ),
            MenuItem(
                imagePath = "file:///android_asset/images/menu_outlines/experience.png",
                menuName = "Experience",
                menuId = MenuId.MENU_ID_EXPERIENCE
            ),
            MenuItem(
                imagePath = "file:///android_asset/images/menu_outlines/technology.png",
                menuName = "Technology",
                menuId = MenuId.MENU_ID_TECHNOLOGY
            ),
            MenuItem(
                imagePath = "file:///android_asset/images/menu_outlines/videos.png",
                menuName = "Videos",
                menuId = MenuId.MENU_ID_VIDEOS
            ),
            MenuItem(
                imagePath = "file:///android_asset/images/menu_outlines/about.png",
                menuName = "About",
                menuId = MenuId.MENU_ID_ABOUT
            )
        )

        val result = repository.getMenuItemsList()

        assertEquals(expectedMenuItemList, result)
    }
}