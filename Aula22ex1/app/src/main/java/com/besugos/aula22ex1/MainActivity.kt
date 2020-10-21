package com.besugos.aula22ex1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewManager = LinearLayoutManager(this)

        //val viewManager = GridLayoutManager(this, 2)

        val recyclerView = findViewById<RecyclerView>(R.id.minhaLista)

        val linha1 = Header("Conversa 1", "11:30", "Resumo da conversa 1")
        val linha2 = Header("Conversa 2", "11:29", "Resumo da conversa 2")
        val linha3 = Header("Conversa 3", "11:28", "Resumo da conversa 3")
        val linha4 = Header("Conversa 4", "11:27", "Resumo da conversa 4")
        val linha5 = Header("Conversa 5", "11:26", "Resumo da conversa 5")

        val viewAdapter = MeuAdapter(arrayListOf(linha1, linha2, linha3, linha4, linha5))

        recyclerView.apply {
            setHasFixedSize(true)

            layoutManager = viewManager
            adapter = viewAdapter

            //addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            //addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL))
        }
    }
}