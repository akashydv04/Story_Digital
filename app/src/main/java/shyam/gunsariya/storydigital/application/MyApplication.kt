package shyam.gunsariya.storydigital.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import shyam.gunsariya.storydigital.module.networkModule
import shyam.gunsariya.storydigital.module.repositoryModule
import shyam.gunsariya.storydigital.module.viewModelModule

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        //koin application start
        startKoin {
            androidLogger()
            androidContext(androidContext = this@MyApplication)
            modules(networkModule)
            modules(
                viewModelModule
            )
            modules(repositoryModule)

        }
    }
}