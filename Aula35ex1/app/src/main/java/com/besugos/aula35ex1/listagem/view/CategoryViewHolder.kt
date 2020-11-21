package com.besugos.aula35ex1.listagem.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.besugos.aula35ex1.R
import com.squareup.picasso.Picasso

class CategoryViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    private val nome = view.findViewById<TextView>(R.id.txtName)

    fun bind(category: String) {
        nome.text = category.capitalize()
    }
}
