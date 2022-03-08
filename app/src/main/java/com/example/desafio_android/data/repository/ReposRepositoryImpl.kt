package com.example.desafio_android.data.repository

import com.example.desafio_android.data.source.ReposDataSource
import com.example.desafio_android.domain.model.ItemsModel

internal class ReposRepositoryImpl(private val dataSource: ReposDataSource): ReposRepository {
    override suspend fun getRepos(): ItemsModel {
        TODO("Not yet implemented")
    }
}