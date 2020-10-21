package com.besugos.aula22exrick

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.besugos.aula22exrick.api.Personagem

class meuAdapter(private val personagens: List<Personagem>) :
    RecyclerView.Adapter<meuViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): meuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista_card, parent, false)

        return meuViewHolder(view)
    }

    override fun getItemCount() = personagens.size

    override fun onBindViewHolder(holder: meuViewHolder, position: Int) {
        holder.bind(personagens[position])
    }
}