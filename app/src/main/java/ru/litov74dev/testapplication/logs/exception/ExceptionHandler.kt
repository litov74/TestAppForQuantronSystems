package ru.litov74dev.testapplication.logs.exception

import timber.log.Timber
import kotlin.system.exitProcess

class ExceptionHandler : Thread.UncaughtExceptionHandler {

    override fun uncaughtException(t: Thread, e: Throwable) {
        Timber.e(e)
        exitProcess(1)
    }

}