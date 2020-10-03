package com.besugos.aula16ex2_meunome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnExibir.setOnClickListener {
            val nome = edtNome.text.toString()
            txtMeuNome.text = getString(R.string.meuNomeEh)
            txtNomeFinal.text = nome
        }

    }
}