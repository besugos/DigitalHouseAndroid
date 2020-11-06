package com.besugos.aula28ex.contador.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.besugos.aula28ex.R
import com.besugos.aula28ex.contador.viewmodel.ContadorViewModel
import com.besugos.aula28ex.contador.viewmodel.ContadorViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var _viewModel: ContadorViewModel

    private val _texto by lazy { findViewById<TextView>(R.id.tvContador) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()

        setupUI()

    }

    private fun setupViewModel() {
        _viewModel = ViewModelProvider(
                this,
                ContadorViewModelFactory()
        ).get(ContadorViewModel::class.java)

        _viewModel.contador.observe(this, alterarTexto)

    }

    private val alterarTexto = Observer<Int> {
        Log.i(TAG, "alterarTexto")
        _texto.text = it.toString()
    }

    private fun setupUI() {
        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            _viewModel.incrementar()
        }
    }

    companion object {
        val TAG = "MainActivity"
    }
}