package com.besugos.aula35ex1.piada.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.besugos.aula35ex1.piada.model.PiadaModel
import com.besugos.aula35ex1.piada.repository.PiadaRepository
import com.besugos.aula35ex1.piada.viewmodel.PiadaViewModel
import com.besugos.aula35ex1.R
import com.squareup.picasso.Picasso

class PiadaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_piada, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val imagem = view.findViewById<ImageView>(R.id.imgJoke)
//        val piada = view.findViewById<TextView>(R.id.txtJoke)

        val categoria = arguments?.getString("CATEGORIA")

        val viewModel = ViewModelProvider(this, PiadaViewModel.JokeViewModelFactory(PiadaRepository())).get(PiadaViewModel::class.java)

        viewModel.obterPiada(categoria!!).observe(viewLifecycleOwner,{
            mostrarResultado(it, view)
        })

//        piada.text = categoria


    }

    fun mostrarResultado(it: PiadaModel, view: View) {
        val imagem = view.findViewById<ImageView>(R.id.imgJoke)
        val piada = view.findViewById<TextView>(R.id.txtJoke)

        piada.text = it.value

        Picasso.get()
            .load(it.iconUrl)
            .into(imagem)
    }

}