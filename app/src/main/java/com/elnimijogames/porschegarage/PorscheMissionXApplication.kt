package com.elnimijogames.porschegarage

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class PorscheMissionXApplication @Inject constructor() : Application() {

    override fun onCreate() {
        super.onCreate()

        initLogging()
    }

    fun initLogging() {
        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree());
        } else {
            val x = 6
        }
    }
}
