package com.besugos.aula23RickCardGrid.api

//import android.telecom.Call
import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {

    @GET("character")
    fun getPersonagens() : retrofit2.Call<Resultado>

}