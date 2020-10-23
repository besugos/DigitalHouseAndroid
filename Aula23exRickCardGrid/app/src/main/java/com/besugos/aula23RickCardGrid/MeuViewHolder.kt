package com.besugos.aula23RickCardGrid


import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.besugos.aula23RickCardGrid.api.Personagem
import com.squareup.picasso.Picasso

class MeuViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val ivImage: ImageView = view.findViewById(R.id.ivPic)
    private val tvName: TextView = view.findViewById(R.id.tv_name)
//    private val tvStatus: TextView = view.findViewById(R.id.tv_status)
//    private val tvSpecie : TextView = view.findViewById(R.id.tv_specie)
//    private val tvLocation: TextView = view.findViewById(R.id.tv_location)

    fun bind(personagem: Personagem) {

        loadImage(personagem)

        tvName.text = personagem.nome
//        tvStatus.text = personagem.status
//        tvSpecie.text = personagem.especie
//        tvLocation.text = personagem.localizacao.nome

    }

    private fun loadImage(personagem: Personagem) {
        Picasso.get()
            .load(personagem.imagemUrl)
            .into(ivImage)
    }

}
