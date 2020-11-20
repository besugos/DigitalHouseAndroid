package com.besugos.kotlinrickappreprise.data.api

interface OnResult<T> {
    fun onSucess(result: T)
    fun onFailure()
}