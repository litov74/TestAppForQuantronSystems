package ru.litov74dev.testapplication.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber
import ru.litov74dev.testapplication.navigation.Navigation

open class BaseActivity : AppCompatActivity() {

    var isOpenVideo = false
    val TAG = "BASE_ACTIVITY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d(TAG, "onCreate")
    }

    override fun onBackPressed() {
        if (this is Navigation) {
            (this as Navigation).goBack()
        } else {
            super.onBackPressed()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}