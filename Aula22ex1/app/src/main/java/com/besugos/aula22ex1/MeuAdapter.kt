package com.besugos.aula22ex1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MeuAdapter(private val dataSet: List<Header>): RecyclerView.Adapter<MeuAdapter.MeuViewHolder>() {

    class MeuViewHolder(view: View): RecyclerView.ViewHolder(view) {

        //private val meuTexto by lazy { view.findViewById(R.id.meuTexto) as TextView }

        private val txtTitulo: TextView = view.findViewById(R.id.txtTitulo)
        private val txtHora: TextView = view.findViewById(R.id.txtHora)
        private val txtResumo: TextView = view.findViewById(R.id.txtResumo)
        //private val img: ImageView = view.findViewById(R.id.img)

        fun bind(header: Header) {
            txtTitulo.text = header.titulo
            txtHora.text = header.hora
            txtResumo.text = header.resumo
            //img.setImageURI(header.img)
        }

    }


    // Inflar o XML (a linha)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)

        return MeuViewHolder(view)
    }


    //Qtd de itens no Dataset
    override fun getItemCount() = dataSet.size



    //vai ser chamado a cada item do Dataset
    override fun onBindViewHolder(holder: MeuViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }


}