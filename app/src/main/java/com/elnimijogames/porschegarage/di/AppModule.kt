package com.elnimijogames.porschegarage.di

import android.content.Context
import com.elnimijogames.porschegarage.model.MenuDetailsRepository
import com.elnimijogames.porschegarage.model.MenuItemListInterface
import com.elnimijogames.porschegarage.model.MenuItemListLocal
import com.elnimijogames.porschegarage.model.MenuItemRepository
import com.elnimijogames.porschegarage.model.MenuPhotoGalleryRepository
import com.elnimijogames.porschegarage.model.StringResourceProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

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

    @Provides
    fun providesStringResourceProvider(@ApplicationContext appContext: Context): StringResourceProviderImpl {
        return StringResourceProviderImpl(appContext.resources)
    }

    @Provides
    fun providesStringResourceProviderImpl(@ApplicationContext appContext: Context): StringResourceProviderImpl {
        return StringResourceProviderImpl(appContext.resources)
    }

    @Provides
    fun providesDetailsScreenRepository(@ApplicationContext appContext: Context): MenuDetailsRepository {
        val stringResourceProvider = StringResourceProviderImpl(appContext.resources)
        return MenuDetailsRepository(stringResourceProvider)
    }
}