package com.besugos.aula16ex3conversor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnConverter.setOnClickListener {

            if (edtCelsius.text.toString() != "") {
                var celsius = edtCelsius.text.toString().toInt()
                var fahrenheit = ((celsius * 9) / 5) + 32
                txtFahrenheit.text = "%d °F".format(fahrenheit)
            }

        }

    }
}
