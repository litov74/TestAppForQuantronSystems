package ru.litov74dev.testapplication.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import ru.litov74dev.testapplication.R
import androidx.appcompat.app.AppCompatActivity
import ru.litov74dev.testapplication.base.isTablet

class SplashActivity : AppCompatActivity() {

    val SPLASH_TIMEOUT_SEC = 1L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler()

        handler.postDelayed({
                            goToNextScreen()
        }, SPLASH_TIMEOUT_SEC * 1000)

    }

    private fun goToNextScreen() {
        if(isFinishing) {
            return
        }

        val i = if(isTablet()) {
            Intent(this, TabActivity::class.java)
        } else {
            Intent(this, PhoneActivity::class.java)
        }
        intent.extras?.let {i.putExtras(it)}

        startActivity(i)
        finish()

    }

}