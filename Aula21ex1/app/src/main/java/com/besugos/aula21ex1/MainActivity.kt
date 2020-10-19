package com.besugos.aula21ex1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var manager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = supportFragmentManager

        btnA.setOnClickListener {
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.frgContainer, MeuFragment())
            transaction.commit()
        }

        btnB.setOnClickListener {
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.frgContainer, OutroFragment())
            transaction.commit()
        }


    }
}