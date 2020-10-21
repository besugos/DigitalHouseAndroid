package com.besugos.aula22ex2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.besugos.aula22ex2.api.Personagem


class MeuAdapter(private val personagens: List<Personagem>) :
    RecyclerView.Adapter<MeuViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista_card, parent, false)

        return MeuViewHolder(view)
    }

    override fun getItemCount() = personagens.size

    override fun onBindViewHolder(holder: MeuViewHolder, position: Int) {
        holder.bind(personagens[position])
    }
}