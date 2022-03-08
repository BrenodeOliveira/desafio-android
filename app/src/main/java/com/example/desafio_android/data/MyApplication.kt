package com.example.desafio_android.data

import android.app.Application
import com.example.desafio_android.di.dataModule
import com.example.desafio_android.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

internal class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(dataModule, presentationModule)
        }
    }
}