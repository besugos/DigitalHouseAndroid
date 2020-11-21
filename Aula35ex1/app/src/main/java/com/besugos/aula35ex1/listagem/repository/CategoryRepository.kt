package com.besugos.aula35ex1.listagem.repository

class CategoryRepository {
    private val client = CategoryEndpoint.endpoint

    suspend fun obterLista() = client.obterLista()
}