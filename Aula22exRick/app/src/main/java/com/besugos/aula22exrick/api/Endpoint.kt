package com.besugos.aula22exrick.api

//import android.telecom.Call
import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {

    @GET("character")
    fun getPersonagens() : retrofit2.Call<Resultado>

}