package com.example.desafio_android.data.remote.source

import com.example.desafio_android.data.remote.model.ItemsData

interface ReposDataSource {

    suspend fun getRepos(): ItemsData
}