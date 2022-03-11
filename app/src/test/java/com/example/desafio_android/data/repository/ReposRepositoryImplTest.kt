package com.example.desafio_android.data.repository

import com.example.desafio_android.data.remote.api.GetRepositoriesService
import com.example.desafio_android.data.remote.model.ItemsData
import com.example.desafio_android.data.remote.model.RepoData
import com.example.desafio_android.data.remote.model.UserData
import com.example.desafio_android.data.remote.repository.ReposRepositoryImpl
import com.example.desafio_android.data.remote.source.ReposDataSourceImpl
import com.example.desafio_android.extensions.toModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Test

@ExperimentalCoroutinesApi
class ReposRepositoryImplTest {

    private val itemsData = ItemsData(listOf())
    private val repoData = RepoData("", 0,0, UserData("", ""), "")
    private val service = mockk<GetRepositoriesService>(relaxed = true)
    private val dataSource = ReposDataSourceImpl(service)
    private val repository = ReposRepositoryImpl(dataSource)

    @Test
    fun `Repository Should return a ItemsModel When dataSource returns success`() = runBlockingTest {
        //Given
        coEvery { dataSource.getRepos() } returns itemsData
        val itemsModel = repoData.toModel()
        //When
        val result = repository.getRepos() //Arrumar
        //Then
        assertEquals(itemsModel, result)
    }

    @Test
    fun `repository Should return a empty list When dataSource returns error`() = runBlockingTest {
        //Given
        coEvery { dataSource.getRepos() } returns itemsData
        //When
        val result = repository.getRepos()
        //Then
        assertEquals(itemsData, result)
    }
}