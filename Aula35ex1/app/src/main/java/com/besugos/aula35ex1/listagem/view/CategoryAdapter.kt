package com.besugos.aula35ex1.listagem.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.besugos.aula35ex1.R

//class CategoryAdapter (private var categories: List<String>, private val listener: (String) -> Unit):
class CategoryAdapter (private var categories: List<String>):
    RecyclerView.Adapter<CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = categories[position]

        holder.bind(item)

        holder.itemView.setOnClickListener {

            val navController = Navigation.findNavController(it)

            val bundle = bundleOf(
                "CATEGORIA" to item
            )
            navController.navigate(R.id.jokeFragment, bundle)

        }
    }

    override fun getItemCount() = categories.size
}