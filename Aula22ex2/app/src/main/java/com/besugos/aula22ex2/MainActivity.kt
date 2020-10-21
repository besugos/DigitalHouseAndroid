package com.besugos.aula22ex2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.besugos.aula22ex2.api.IRespostaDaApi
import com.besugos.aula22ex2.api.Personagem
import com.besugos.aula22ex2.api.RickApi


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewManager = GridLayoutManager(this, 3)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        RickApi.getData(this, object : IRespostaDaApi {
            override fun obtevePersonagens(personagens: List<Personagem>) {
                val viewAdapter = MeuAdapter(personagens)
                with(recyclerView) {
                    setHasFixedSize(true)
                    layoutManager = viewManager
                    adapter = viewAdapter
                    addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
                    addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL))
                }
            }
        })
    }
}