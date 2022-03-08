package com.example.desafio_android.di

import com.example.desafio_android.data.api.GetRepositoriesService
import com.example.desafio_android.data.retrofit.ApiService
import com.example.desafio_android.data.retrofit.HttpClient
import com.example.desafio_android.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {
    factory {
        HttpClient(retrofit = ApiService.initRetrofit())
    }

    factory {
        get<HttpClient>().create(
            service = GetRepositoriesService::class.java
        )
    }
}

val presentationModule = module {
    viewModel {
        MainViewModel()
    }
}