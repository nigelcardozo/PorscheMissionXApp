//package com.elnimijogames.porschegarage.ui.mainmenu
//
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.setValue
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.elnimijogames.porschegarage.model.MenuItemRepository
//import com.elnimijogames.porschegarage.model.MenuPhotoGalleryRepository
//import androidx.test.espresso.matcher.ViewMatchers.withText
//import androidx.test.espresso.assertion.ViewAssertions.matches
//import androidx.test.espresso.Espresso.onView
//import androidx.test.espresso.action.ViewActions.click
//import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
//import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
//import androidx.test.espresso.matcher.ViewMatchers.withId
//import androidx.test.ext.junit.rules.ActivityScenarioRule
//import androidx.test.ext.junit.runners.AndroidJUnit4
//import com.elnimijogames.porschegarage.MainActivity
//import dagger.hilt.android.lifecycle.HiltViewModel
//import dagger.hilt.android.testing.HiltAndroidRule
//import dagger.hilt.android.testing.HiltAndroidTest
//import dagger.hilt.android.testing.HiltViewModelTest
//import dagger.hilt.android.testing.UninstallModules
//import org.junit.Assert.assertEquals
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//import org.junit.runner.RunWith
//import javax.inject.Inject
//
//@HiltAndroidTest
//@RunWith(AndroidJUnit4::class)
//@UninstallModules(MenuItemRepositoryModule::class, MenuPhotoGalleryRepositoryModule::class)
//class MainMenuViewModelTest {
//
//    @get:Rule
//    var hiltRule = HiltAndroidRule(this)
//
//    @get:Rule
//    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)
//
//    @Inject
//    lateinit var galleryRepository: MenuPhotoGalleryRepository
//
//    @Inject
//    lateinit var menuItemRepository: MenuItemRepository
//
//    @Before
//    fun setup() {
//        hiltRule.inject()
//    }
//
//    @HiltViewModelTest
//    fun testMainMenuViewModel() {
//        val viewModel = MainMenuViewModel(galleryRepository, menuItemRepository)
//
//        val expectedGalleryList = galleryRepository.getImageGalleryList()
//        val expectedMenuList = menuItemRepository.getMenuItemsList()
//
//        assertEquals(expectedGalleryList, viewModel.photoGalleryState.value)
//        assertEquals(expectedMenuList, viewModel.itemMenuState.value)
//    }
//
//    @Test
//    fun testMainMenuScreenDisplayed() {
//        activityScenarioRule.scenario.onActivity { activity ->
//            val viewModel = MainMenuViewModel(galleryRepository, menuItemRepository)
//
//            // Verify the photo gallery is displayed
//            val expectedGalleryList = galleryRepository.getImageGalleryList()
//            for (imageUrl in expectedGalleryList) {
//                onView(withId(R.id.photoGalleryRecyclerView))
//                    .perform(scrollToPosition<RecyclerView.ViewHolder>(expectedGalleryList.indexOf(imageUrl)))
//                    .check(matches(isDisplayed()))
//            }
//
//            // Verify the menu items are displayed
//            val expectedMenuList = menuItemRepository.getMenuItemsList()
//            for (menuItem in expectedMenuList) {
//                onView(withText(menuItem.name)).check(matches(isDisplayed()))
//            }
//        }
//    }
//
//    @Test
//    fun testMenuItemClick() {
//        activityScenarioRule.scenario.onActivity { activity ->
//            val viewModel = MainMenuViewModel(galleryRepository, menuItemRepository)
//
//            // Perform a click on the first menu item
//            val expectedMenuList = menuItemRepository.getMenuItemsList()
//            onView(withText(expectedMenuList[0].name)).perform(click())
//
//            // TODO: Add assertions for the expected behavior after the menu item click
//            // For example, you can check if a specific action is performed or a new screen is displayed
//        }
//    }
//}