package com.example.desafio_android.data.remote.repository

import com.example.desafio_android.data.remote.source.ReposDataSource
import com.example.desafio_android.domain.model.RepoModel
import com.example.desafio_android.extensions.toModel

internal class ReposRepositoryImpl(private val dataSource: ReposDataSource): ReposRepository {
    override suspend fun getRepos(): List<RepoModel> {
        return dataSource.getRepos().items?.map { it.toModel() } ?: listOf()
    }
}