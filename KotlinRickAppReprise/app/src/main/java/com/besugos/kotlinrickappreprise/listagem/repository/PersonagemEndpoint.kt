package com.besugos.kotlinrickappreprise.listagem.repository

import com.besugos.kotlinrickappreprise.data.model.ResponseModel
import com.besugos.kotlinrickappreprise.listagem.model.PersonagemModel
import retrofit2.Call
import retrofit2.http.GET

interface PersonagemEndpoint {

    @GET("character")
    fun obterLista(): Call<ResponseModel<PersonagemModel>>
}