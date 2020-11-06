package com.besugos.aula25

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        deixarFullscreen()

        setContentView(R.layout.activity_splash)

        animaTexto()

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)


    }

    private fun animaTexto() {
        val appName = findViewById<TextView>(R.id.appName)
        appName.alpha = 0f
        appName.y = 1000f
        appName.scaleX = 0f
        appName.scaleY = 0f

        appName.animate()
            .alpha(1f)
            .y(800f)
            .setDuration(1500)
            .scaleX(1f)
            .scaleY(1f)
            .setListener(null)

    }

    private fun deixarFullscreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
    }


}


