package com.besugos.aula16ex4salariohora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnConverter.setOnClickListener {
            if (edtHoras.text.toString() != "" && edtValor.text.toString() != "") {
                var horas = edtHoras.text.toString().toDouble()
                var valor = edtValor.text.toString().toDouble()
                var resultado = horas * valor
                txtResultado.text = "R$ %.2f".format(resultado)
            }
        }
    }
}