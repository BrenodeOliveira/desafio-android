package com.example.desafio_android.data.remote.retrofit

import retrofit2.Retrofit

class HttpClient(private val retrofit: Retrofit) {
    fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }
}