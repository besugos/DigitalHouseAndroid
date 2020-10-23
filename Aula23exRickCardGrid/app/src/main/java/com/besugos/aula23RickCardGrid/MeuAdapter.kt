package com.besugos.aula23RickCardGrid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.besugos.aula23RickCardGrid.api.Personagem

class MeuAdapter(private val personagens: List<Personagem>, private val listener: (Personagem) -> Unit) :
    RecyclerView.Adapter<MeuViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista_card, parent, false)

        return MeuViewHolder(view)
    }

    override fun getItemCount() = personagens.size

    override fun onBindViewHolder(holder: MeuViewHolder, position: Int) {
        val item = personagens[position]
        holder.bind(item)

        holder.itemView.setOnClickListener { listener(item) }
    }
}