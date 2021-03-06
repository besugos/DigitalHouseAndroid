package com.besugos.aula22exrick.api

import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("count")
    val total: Int,
    @SerializedName("pages")
    val paginas: Int,
    @SerializedName("next")
    val proximo: String?,
    @SerializedName("prev")
    val anterior: String?
)