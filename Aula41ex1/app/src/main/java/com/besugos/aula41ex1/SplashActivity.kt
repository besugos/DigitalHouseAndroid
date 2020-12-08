package com.besugos.aula41ex1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val prefs = getSharedPreferences("App42ex1_Prefs", MODE_PRIVATE)
        val prefsConnected = prefs.getBoolean("KEEP_CONNECTED_PREFS", false)


        if (prefsConnected) {
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }, 1000)
        } else {
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }, 1000)
        }


    }

    companion object {
        const val APP_NAME = "Splash_Prefs"
        const val KEEP_CONNECTED_PREFS = "KEEP_CONNECTED_PREFS"
    }
}
