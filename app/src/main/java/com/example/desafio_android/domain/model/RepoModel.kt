package com.example.desafio_android.domain.model

data class RepoModel(
    val name: String,
    val forks: String,
    val stars: String,
    val user: UserModel,
    val language: String,
)
