package com.example.desafio_android.data.remote.source

import com.example.desafio_android.data.remote.api.GetRepositoriesService
import com.example.desafio_android.data.remote.model.ItemsData

internal class ReposDataSourceImpl(private val service: GetRepositoriesService): ReposDataSource {

    override suspend fun getRepos(): ItemsData {
        return service.getRepositories()
    }
}