package com.example.rxkoinapp

import android.app.Application
import com.example.rxkoinapp.di.missionDtoMapperModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RxKoinApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@RxKoinApplication)
            modules(listOf(missionDtoMapperModule))
        }
    }

}