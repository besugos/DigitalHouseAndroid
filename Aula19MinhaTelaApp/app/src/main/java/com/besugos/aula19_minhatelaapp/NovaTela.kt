package com.besugos.aula19_minhatelaapp

import android.annotation.SuppressLint
//import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_nova_tela.*

class NovaTela : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nova_tela)


        val name = intent.getStringExtra("NAME")
        val idade = intent.getIntExtra("IDADE", 0)


        txtTexto.text = "$name $idade"



    }
}