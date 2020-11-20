package com.besugos.kotlinrickappreprise.listagem.repository

import com.besugos.kotlinrickappreprise.data.api.NetworkUtils
import com.besugos.kotlinrickappreprise.data.api.OnResult
import com.besugos.kotlinrickappreprise.data.model.ResponseModel
import com.besugos.kotlinrickappreprise.listagem.model.PersonagemModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonagemRepository {

    fun obterLista(onResult: OnResult<ResponseModel<PersonagemModel>>) {
        val client = NetworkUtils.getRetrofitInstance()
        val api = client.create(PersonagemEndpoint::class.java)
        val call = api.obterLista()
        call.enqueue(object: Callback<ResponseModel<PersonagemModel>> {
            override fun onResponse(
                call: Call<ResponseModel<PersonagemModel>>,
                response: Response<ResponseModel<PersonagemModel>>
            ) {
                onResult.onSucess(response.body()!!)
            }

            override fun onFailure(call: Call<ResponseModel<PersonagemModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}

