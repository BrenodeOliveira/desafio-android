package com.example.desafio_android.data.source

import com.example.desafio_android.data.model.ItemsData

interface ReposDataSource {

    suspend fun getRepos(): ItemsData
}