package com.example.desafio_android.presentation.viewmodel

import com.example.desafio_android.domain.model.RepoModel
import com.example.desafio_android.domain.usecase.GetReposUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import org.junit.Test

class MainViewModelTest {

    private val repoList = listOf<RepoModel>()
    private val useCase = mockk<GetReposUseCase>(relaxed = true)
    private val viewModel = MainViewModel(useCase)

    @Test
    fun `viewModel Should return a list of repos When useCase returns success`() {
        //Given
        coEvery { useCase.invoke() } returns repoList
        //When
        viewModel.getRepos()
        //Then
        coVerify {
            useCase.invoke()
        }
    }
}