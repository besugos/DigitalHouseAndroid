package com.besugos.aula35ex1.piada.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.besugos.aula35ex1.piada.repository.PiadaRepository
import kotlinx.coroutines.Dispatchers

class PiadaViewModel (
    private val _repository: PiadaRepository
): ViewModel() {

        fun obterPiada(categoria:String) = liveData(Dispatchers.IO){
            val mensagem = _repository.obterPiada(categoria)

            emit(mensagem)
        }

        class JokeViewModelFactory(
            private val respository: PiadaRepository
        ): ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return PiadaViewModel(respository) as T
            }

        }
    }