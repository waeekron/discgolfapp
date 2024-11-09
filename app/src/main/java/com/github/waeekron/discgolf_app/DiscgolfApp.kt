package com.github.waeekron.discgolf_app

import android.app.Application
import com.github.waeekron.discgolf_app.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class DiscgolfApp: Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@DiscgolfApp)
            androidLogger()
            modules(AppModule)
        }
    }

}