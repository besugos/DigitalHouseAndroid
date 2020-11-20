package com.besugos.kotlinrickappreprise.listagem.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.besugos.kotlinrickappreprise.R
import com.besugos.kotlinrickappreprise.listagem.model.PersonagemModel
import com.besugos.kotlinrickappreprise.listagem.repository.PersonagemRepository
import com.besugos.kotlinrickappreprise.listagem.viewmodel.PersonagemViewModel

class ListaFragment : Fragment() {

    lateinit var _viewModel: PersonagemViewModel
    lateinit var _view: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _view = view

        val lista = view.findViewById<RecyclerView>(R.id.lista)
        val manager = LinearLayoutManager(view.context)

        val listaDePersonagens = mutableListOf<PersonagemModel>()
        val listaAdapter = ListaAdapter(listaDePersonagens)

        lista.apply {
            setHasFixedSize(true)
            layoutManager = manager
            adapter = listaAdapter
        }

        _viewModel = ViewModelProvider(
            this,
            PersonagemViewModel.PersonagemViewModelFactory(PersonagemRepository())

        ).get(PersonagemViewModel::class.java)

        _viewModel.personagens.observe(this, Observer {
            showLoading(false)
            notFound(view, it.isNotEmpty())

            listaDePersonagens.addAll(it)
            listaAdapter.notifyDataSetChanged()
        })

        _viewModel.obterLista()
        showLoading(true)

    }

    fun showLoading(isLoading: Boolean){
        val viewLoading = _view.findViewById<View>(R.id.carregando)
        viewLoading.visibility = View.VISIBLE

        if (isLoading) {
            viewLoading.visibility = View.VISIBLE
        } else {
            viewLoading.visibility = View.GONE
        }
    }

    fun notFound(view: View, notFound: Boolean) {
        if (notFound) {
            _view.findViewById<View>(R.id.notFoundLayout).visibility = View.GONE
        } else {
            _view.findViewById<View>(R.id.notFoundLayout).visibility = View.VISIBLE
        }
    }


}