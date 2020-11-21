package com.besugos.aula35ex1.piada.repository

import com.besugos.aula35ex1.piada.model.PiadaModel
import com.besugos.aula35ex1.api.NetworkUtils
import retrofit2.http.GET
import retrofit2.http.Query

interface PiadaEndpoint {
    @GET("random")
    suspend fun obterPiada(@Query("category") category: String?): PiadaModel

    companion object {
        val endpoint: PiadaEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(PiadaEndpoint::class.java)
        }
    }
}