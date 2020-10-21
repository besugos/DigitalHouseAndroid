package com.besugos.aula22ex2


import android.view.View
import android.widget.ImageView

import androidx.recyclerview.widget.RecyclerView
import com.besugos.aula22ex2.api.Personagem
import com.squareup.picasso.Picasso

class MeuViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val ivImage: ImageView = view.findViewById(R.id.iv_image)


    fun bind(personagem: Personagem) {

        loadImage(personagem)

    }

    private fun loadImage(personagem: Personagem) {
        Picasso.get()
            .load(personagem.imagemUrl)
            .into(ivImage)
    }

}
