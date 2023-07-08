package com.elnimijogames.porschegarage.di

import com.elnimijogames.porschegarage.model.MenuPhotoGalleryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class AppModule {
    @Provides
    fun providesMenuPhotoGalleryRepository(): MenuPhotoGalleryRepository {
        return MenuPhotoGalleryRepository()
    }
}