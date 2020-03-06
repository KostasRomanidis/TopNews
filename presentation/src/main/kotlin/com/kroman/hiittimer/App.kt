package com.kroman.hiittimer

import android.app.Application
import com.facebook.stetho.Stetho
import com.kroman.hiitimer.BuildConfig
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
            Timber.plant(Timber.DebugTree())
        }
    }
}