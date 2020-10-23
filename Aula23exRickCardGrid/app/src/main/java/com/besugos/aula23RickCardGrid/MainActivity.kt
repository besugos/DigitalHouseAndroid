package com.besugos.aula23RickCardGrid

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.besugos.aula23RickCardGrid.api.IRespostaDaApi
import com.besugos.aula23RickCardGrid.api.Personagem
import com.besugos.aula23RickCardGrid.api.RickApi


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RickApi.getData(this, object: IRespostaDaApi {
            override fun obtevePersonagens(personagens: List<Personagem>) {
                criarLista(personagens)
            }
        })
    }

    fun criarLista(personagens: List<Personagem>) {
        val recyclerView = findViewById<RecyclerView>(R.id.rv_lista)
        val manager = GridLayoutManager(this, 2)

       // val customAdapter = MeuAdapter(personagens)
        var toast: Toast? = null

        val customAdapter = MeuAdapter(personagens) {
//            toast?.cancel()
//
//            toast = Toast.makeText(this@MainActivity, it.nome, Toast.LENGTH_LONG)
//            toast?.show()

            var intent = Intent(this@MainActivity, DetalhesActivity::class.java)
            intent.putExtra("name", it.nome)
            intent.putExtra("image", it.imagemUrl)
            intent.putExtra("planet", it.localizacao.nome)
            intent.putExtra("gender", it.genero)
            startActivity(intent)

        }

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = manager
            adapter = customAdapter
        }
    }
}
