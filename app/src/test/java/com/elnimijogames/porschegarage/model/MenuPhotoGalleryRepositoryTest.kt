package com.elnimijogames.porschegarage.model

import org.junit.Test

import org.junit.Assert.*

class MenuPhotoGalleryRepositoryTest {

    @Test
    fun getImageGalleryList_returnsExpectedList() {
        val repository = MenuPhotoGalleryRepository()

        val expectedList = listOf(
            "file:///android_asset/images/cars/porsche1.jpg",
            "file:///android_asset/images/cars/porsche2.jpg",
            "file:///android_asset/images/cars/porsche3.jpg",
            "file:///android_asset/images/cars/porsche4.jpg",
            "file:///android_asset/images/cars/porsche5.jpg",
            "file:///android_asset/images/cars/porsche6.jpg",
            "file:///android_asset/images/cars/porsche7.jpg",
            "file:///android_asset/images/cars/porsche8.jpg",
            "file:///android_asset/images/cars/porsche9.jpg",
            "file:///android_asset/images/cars/porsche10.jpg",
            "file:///android_asset/images/cars/porsche11.jpg",
            "file:///android_asset/images/cars/porsche12.jpg",
            "file:///android_asset/images/cars/porsche13.jpg",
            "file:///android_asset/images/cars/porsche14.jpg",
            "file:///android_asset/images/cars/porsche15.jpg",
            "file:///android_asset/images/cars/porsche16.jpg",
            "file:///android_asset/images/cars/porsche17.jpg",
            "file:///android_asset/images/cars/porsche18.jpg",
            "file:///android_asset/images/cars/porsche19.jpg",
            "file:///android_asset/images/cars/porsche20.jpg",
            "file:///android_asset/images/cars/porsche21.jpg",
            "file:///android_asset/images/cars/porsche22.jpg",
            "file:///android_asset/images/cars/porsche23.jpg",
            "file:///android_asset/images/cars/porsche24.jpg",
            "file:///android_asset/images/cars/porsche25.jpg",
            "file:///android_asset/images/cars/porsche26.jpg"
        )

        val result = repository.getImageGalleryList()

        assertEquals(expectedList, result)
    }
}