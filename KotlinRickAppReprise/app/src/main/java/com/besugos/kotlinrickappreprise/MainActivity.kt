package com.besugos.kotlinrickappreprise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.besugos.kotlinrickappreprise.listagem.view.ListaFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, ListaFragment())
            .commit()
    }
}