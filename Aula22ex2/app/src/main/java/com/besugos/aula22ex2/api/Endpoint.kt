package com.besugos.aula22ex2.api

//import android.telecom.Call
import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {

    @GET("character")
    fun getPersonagens() : retrofit2.Call<Resultado>

}