package ru.litov74dev.testapplication.logs

import timber.log.Timber.*

class ReleaseTree : DebugTree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
//        if (priority == Log.ERROR || priority == Log.WARN)
        super.log(priority, tag, message, t)
    }
}