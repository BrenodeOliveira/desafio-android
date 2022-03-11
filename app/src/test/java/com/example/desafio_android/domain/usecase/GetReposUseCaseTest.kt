package com.example.desafio_android.domain.usecase

import com.example.desafio_android.data.remote.repository.ReposRepository
import com.example.desafio_android.domain.model.RepoModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Test

@ExperimentalCoroutinesApi
class GetReposUseCaseTest {

    private val repoModel = listOf<RepoModel>()
    private val repository = mockk<ReposRepository>(relaxed = true)
    private val useCase = GetReposUseCase(repository)

    @Test
    fun `UseCase Should return a list of RepoModel When repository returns success`() = runBlockingTest {
        //Given
        coEvery { repository.getRepos() } returns repoModel
        //When
        val result = useCase.invoke()
        //Then
        assertEquals(repoModel, result)
    }
}