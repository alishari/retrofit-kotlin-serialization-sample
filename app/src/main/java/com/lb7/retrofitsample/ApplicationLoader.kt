package com.lb7.retrofitsample

import android.app.Application
import com.lb7.retrofitsample.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class ApplicationLoader : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ApplicationLoader)
            modules(appModule)
        }
    }
}