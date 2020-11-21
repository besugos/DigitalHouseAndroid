package com.besugos.aula35ex1.piada.model

import com.google.gson.annotations.SerializedName

data class PiadaModel (
    @SerializedName("icon_url")
    val iconUrl: String,
    val value: String
)



