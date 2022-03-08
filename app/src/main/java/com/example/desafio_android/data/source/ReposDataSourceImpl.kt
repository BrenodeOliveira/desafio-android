package com.example.desafio_android.data.source

import com.example.desafio_android.data.api.GetRepositoriesService
import com.example.desafio_android.data.model.ItemsData

internal class ReposDataSourceImpl(private val service: GetRepositoriesService): ReposDataSource {

    override suspend fun getRepos(): ItemsData {
        return service.getRepositories()
    }
}