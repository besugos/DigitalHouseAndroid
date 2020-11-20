package com.besugos.kotlinrickappreprise.data.model

data class ResponseModel<T> (
    val info: PageInfoModel,
    val results: List<T>

)