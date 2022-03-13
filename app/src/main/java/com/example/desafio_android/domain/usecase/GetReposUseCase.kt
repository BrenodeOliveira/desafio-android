package com.example.desafio_android.domain.usecase

import com.example.desafio_android.data.remote.repository.ReposRepository
import com.example.desafio_android.domain.model.RepoModel

internal class GetReposUseCase(private val reposRepository: ReposRepository) {
    suspend operator fun invoke(): List<RepoModel> {
        return reposRepository.getRepos()
    }
}