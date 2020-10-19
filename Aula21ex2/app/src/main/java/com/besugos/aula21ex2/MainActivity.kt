package com.besugos.aula21ex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), ICalc{

    val fragB = FragB()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = supportFragmentManager

        var transaction = manager.beginTransaction()
        transaction.add(R.id.frA, FragA())
        transaction.commit()

        transaction = manager.beginTransaction()
        transaction.add(R.id.frB, fragB)
        transaction.commit()


    }

    override fun calcula(texto: String) {
        
        fragB.mudaTexto(texto)
    }
}




