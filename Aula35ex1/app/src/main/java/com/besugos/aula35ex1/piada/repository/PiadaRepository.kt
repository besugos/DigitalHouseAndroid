package com.besugos.aula35ex1.piada.repository

class PiadaRepository {
    private val client = PiadaEndpoint.endpoint

    suspend fun obterPiada(categoria:String) = client.obterPiada(categoria)
}