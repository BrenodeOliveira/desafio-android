package com.example.desafio_android.data.remote.api

import com.example.desafio_android.data.remote.model.ItemsData
import retrofit2.http.GET

internal interface GetRepositoriesService {

    @GET("repositories?q=language:kotlin&sort=stars&page=1")
    suspend fun getRepositories(): ItemsData
}