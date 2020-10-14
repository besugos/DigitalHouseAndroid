package com.besugos.aula19_minhatelaapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnClique.setOnClickListener {
//            val intent = Intent(this, NovaTela::class.java)
//
//            intent.putExtra("NAME", "Wendel")
//            intent.putExtra("IDADE", 41)
//
//            startActivity(intent)

            Toast.makeText(this, "Testando o Toast!", Toast.LENGTH_SHORT).show()
        }

        checkVoceDeseja.setOnCheckedChangeListener { _, isChecked ->
            //Toast.makeText(this, isChecked.toString(), Toast.LENGTH_SHORT).show()

            btnClique.isEnabled = isChecked
        }
    }




}