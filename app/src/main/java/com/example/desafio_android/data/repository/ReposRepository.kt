package com.example.desafio_android.data.repository

import com.example.desafio_android.domain.model.ItemsModel

interface ReposRepository {
    suspend fun getRepos(): ItemsModel
}