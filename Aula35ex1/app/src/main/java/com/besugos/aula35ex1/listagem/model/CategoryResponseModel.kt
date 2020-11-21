package com.besugos.aula35ex1.listagem.model

import androidx.annotation.Keep

@Keep
data class CategoryResponseModel<T> (
    val results: List<String>
)