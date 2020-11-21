package com.besugos.aula35ex1.listagem.repository

import com.besugos.aula35ex1.api.NetworkUtils
import retrofit2.http.GET

interface CategoryEndpoint {
    @GET("categories")
    suspend fun obterLista(): List<String>

    companion object {
        val endpoint: CategoryEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(CategoryEndpoint::class.java)
        }
    }
}
