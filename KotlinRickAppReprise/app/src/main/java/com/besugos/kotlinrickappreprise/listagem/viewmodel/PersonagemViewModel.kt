package com.besugos.kotlinrickappreprise.listagem.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.besugos.kotlinrickappreprise.data.api.OnResult
import com.besugos.kotlinrickappreprise.data.model.ResponseModel
import com.besugos.kotlinrickappreprise.listagem.model.PersonagemModel
import com.besugos.kotlinrickappreprise.listagem.repository.PersonagemRepository

class PersonagemViewModel(private val repository: PersonagemRepository): ViewModel() {

    val personagens = MutableLiveData<List<PersonagemModel>>()


    fun obterLista() {
        repository.obterLista(object: OnResult<ResponseModel<PersonagemModel>>{
            override fun onSucess(result: ResponseModel<PersonagemModel>) {
                personagens.value = result.results
            }

            override fun onFailure() {
                TODO("Not yet implemented")
            }

        })
    }

    class PersonagemViewModelFactory(val repository: PersonagemRepository): ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return PersonagemViewModel(repository) as T
        }
    }

}