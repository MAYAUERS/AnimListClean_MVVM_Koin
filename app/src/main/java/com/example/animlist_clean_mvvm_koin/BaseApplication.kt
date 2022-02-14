package com.example.animlist_clean_mvvm_koin

import android.app.Application
import com.example.animlist_clean_mvvm_koin.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BaseApplication:Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
        androidContext(this@BaseApplication)
        androidLogger(Level.DEBUG)
          modules(listOf(retrofitModule, presentationModule, picassoModule, dataModule, domainModule))
        }
    }


}