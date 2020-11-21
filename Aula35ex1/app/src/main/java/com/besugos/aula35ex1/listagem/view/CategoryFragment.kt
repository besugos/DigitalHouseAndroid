package com.besugos.aula35ex1.listagem.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.besugos.aula35ex1.R
import com.besugos.aula35ex1.listagem.repository.CategoryRepository
import com.besugos.aula35ex1.listagem.viewmodel.CategoryViewModel

class CategoryFragment : Fragment() {

    lateinit var _viewModel: CategoryViewModel
    lateinit var _view: View
    private lateinit var _listaAdapter: CategoryAdapter

    private var _listaDeCategorias = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _view = view

        val lista = view.findViewById<RecyclerView>(R.id.lista)
        val manager = LinearLayoutManager(view.context)

        _listaDeCategorias = mutableListOf()
        _listaAdapter = CategoryAdapter(_listaDeCategorias)

        lista.apply {
            setHasFixedSize(true)
            layoutManager = manager
            adapter = _listaAdapter
        }

        _viewModel = ViewModelProvider(
            this,
            CategoryViewModel.CategoryViewModelFactory(CategoryRepository())
        ).get(CategoryViewModel::class.java)

        _viewModel.obterLista().observe(viewLifecycleOwner, {
            exibirResultados(it)
        })


    }

    private fun exibirResultados(lista: List<String>?) {

        lista?.let { _listaDeCategorias.addAll(it) }

        _listaAdapter.notifyDataSetChanged()
    }
}