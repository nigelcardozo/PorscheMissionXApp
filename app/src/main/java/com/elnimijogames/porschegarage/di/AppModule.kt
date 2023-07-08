package com.elnimijogames.porschegarage.di

import com.elnimijogames.porschegarage.model.MenuItemListInterface
import com.elnimijogames.porschegarage.model.MenuItemListLocal
import com.elnimijogames.porschegarage.model.MenuItemRepository
import com.elnimijogames.porschegarage.model.MenuPhotoGalleryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class AppModule {
    @Provides
    fun providesMenuPhotoGalleryRepository(): MenuPhotoGalleryRepository = MenuPhotoGalleryRepository()

    @Provides
    fun providesMenuItemListInterface(): MenuItemListInterface = MenuItemListLocal()

    @Provides
    fun providesMenuItemListLocal(): MenuItemListLocal = MenuItemListLocal()

    @Provides
    fun providesMenuItemRepository(menuItemListLocal: MenuItemListLocal): MenuItemRepository = MenuItemRepository(menuItemListLocal)
}