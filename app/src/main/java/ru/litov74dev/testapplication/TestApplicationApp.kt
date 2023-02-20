package ru.litov74dev.testapplication

import android.app.Application
import android.content.Context
import com.github.anrwatchdog.ANRWatchDog
import dagger.hilt.android.HiltAndroidApp
import ru.litov74dev.testapplication.logs.FileLoggingTree
import ru.litov74dev.testapplication.logs.ReleaseTree
import ru.litov74dev.testapplication.logs.exception.ExceptionHandler
import timber.log.Timber

@HiltAndroidApp
class TestApplicationApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initLogger(this)
    }

    private fun initLogger(context: Context) {
        ANRWatchDog().start()
        Thread.setDefaultUncaughtExceptionHandler(ExceptionHandler())
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree()) else Timber.plant(ReleaseTree())
        Timber.plant(FileLoggingTree(context))
        Timber.i("Logger initialized")
    }

}