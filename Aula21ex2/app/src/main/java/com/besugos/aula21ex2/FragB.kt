package com.besugos.aula21ex2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_frag_a.*
import kotlinx.android.synthetic.main.fragment_frag_b.*
import kotlinx.android.synthetic.main.fragment_frag_b.view.*

class FragB : Fragment(){

    lateinit var viewB: View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewB = inflater.inflate(R.layout.fragment_frag_b, container, false)
        return viewB
    }

    fun mudarTexto(texto: String) {
        viewB.txtIdade.text = texto
    }


    fun mudaTexto(texto: String) {
            viewB.txtIdade.text = texto
    }
}




