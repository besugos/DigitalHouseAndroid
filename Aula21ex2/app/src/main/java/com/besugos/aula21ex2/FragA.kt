package com.besugos.aula21ex2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_frag_a.*
import kotlinx.android.synthetic.main.fragment_frag_a.view.*
import java.util.*

class FragA : Fragment() {

    lateinit var iCalc: ICalc


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_frag_a, container, false)

        view.btnCalcula.setOnClickListener {

            if (etNome.text.toString() != "" && etAno.text.toString() != "") {
                val nome = view.etNome.text.toString()
                val ano = etAno.etAno.text.toString().toInt()
                val anoAtual = Calendar.getInstance().get(Calendar.YEAR)
                val idade = (anoAtual - ano).toString()
                var resultado = ""
                if (idade == "0" || idade == "1") {
                    resultado = "$nome, você tem $idade ano"
                } else if (idade.toInt() < 0){
                    resultado = "$nome, você ainda não nasceu"
                } else {
                    resultado = "$nome, você tem $idade anos"
                }

                iCalc.calcula(resultado)

            }

        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        iCalc = context as ICalc

    }

}