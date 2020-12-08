package com.besugos.aula41ex1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val prefs = getSharedPreferences("App42ex1_Prefs", MODE_PRIVATE)
        val prefsConnected = prefs.getBoolean("KEEP_CONNECTED_PREFS", false)

        val btnLogin = findViewById<Button>(R.id.button)
        val chkKeep = findViewById<CheckBox>(R.id.checkBox)

        chkKeep.isChecked = prefsConnected

        btnLogin.setOnClickListener {
            prefs.edit().putBoolean("KEEP_CONNECTED_PREFS", chkKeep.isChecked).apply()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

}