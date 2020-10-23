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

        val imagem = intent.getStringExtra("IMAGEM")
//        val nome = intent.getStringExtra("NOME")
//        val planeta = intent.getStringExtra("PLANETA")
//        val genero = intent.getStringExtra("GENERO")

        //findViewById<TextView>(R.id.txtNome).text = nome
        //findViewById<TextView>(R.id.txtPlaneta).text = nome
        //findViewById<TextView>(R.id.txtGenero).text = nome

        Picasso.get()
            .load(imagem)
            .into(findViewById<ImageView>(R.id.ivPic))

    }
}