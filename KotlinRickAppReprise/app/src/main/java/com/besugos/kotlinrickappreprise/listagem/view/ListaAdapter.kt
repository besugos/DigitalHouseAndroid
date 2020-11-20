package com.besugos.kotlinrickappreprise.listagem.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.besugos.kotlinrickappreprise.R
import com.besugos.kotlinrickappreprise.listagem.model.PersonagemModel

class ListaAdapter(private var personagens: MutableList<PersonagemModel>): RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_list_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = personagens[position]



        holder.bind(item)
    }

    override fun getItemCount() = personagens.size
}
