package com.example.desafio_android.data.remote.repository

import com.example.desafio_android.domain.model.RepoModel

interface ReposRepository {
    suspend fun getRepos(): List<RepoModel>
}