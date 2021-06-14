package com.gilbertopapa.arch_2021

import android.app.Application
import com.gilbertopapa.network.di.apiModule
import com.gilbertopapa.network.di.databaseModule
import com.gilbertopapa.network.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@Application)
            modules(
                listOf(
                    databaseModule,
                    apiModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}