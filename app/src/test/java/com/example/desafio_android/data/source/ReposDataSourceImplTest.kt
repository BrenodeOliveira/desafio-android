package com.example.desafio_android.data.source

import com.example.desafio_android.data.remote.api.GetRepositoriesService
import com.example.desafio_android.data.remote.model.ItemsData
import com.example.desafio_android.data.remote.source.ReposDataSourceImpl
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Test

@ExperimentalCoroutinesApi
class ReposDataSourceImplTest {

    private val itemsData = ItemsData(listOf())
    private val service = mockk<GetRepositoriesService>(relaxed = true)
    private val dataSourceImpl = ReposDataSourceImpl(service)

    @Test
    fun `DataSource Should return a ItemsData When service has returned success`() = runBlockingTest {
        //Given
        coEvery { service.getRepositories() } returns itemsData
        //When
        val result = dataSourceImpl.getRepos()
        //Then
        assertEquals(itemsData, result)
    }
}