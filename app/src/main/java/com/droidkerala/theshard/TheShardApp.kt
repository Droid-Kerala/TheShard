package com.droidkerala.theshard

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TheShardApp :Application() {

    override fun onCreate() {
        super.onCreate()
    }

}