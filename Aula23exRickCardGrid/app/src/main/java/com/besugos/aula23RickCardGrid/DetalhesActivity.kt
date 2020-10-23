package com.besugos.aula23RickCardGrid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_lista_card.*

class DetalhesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        val imagem = intent.getStringExtra("image")
        val nome = intent.getStringExtra("name")
        val planeta = intent.getStringExtra("planet")
        val genero = intent.getStringExtra("gender")

        findViewById<TextView>(R.id.tvDetName).text = nome
        findViewById<TextView>(R.id.tvDetPlanet).text = planeta
        findViewById<TextView>(R.id.tvDetGender).text = genero

        Picasso.get()
            .load(imagem)
            .into(findViewById<ImageView>(R.id.ivDetPic))

    }
}