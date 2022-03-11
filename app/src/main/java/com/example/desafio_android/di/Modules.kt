package com.example.desafio_android.di

import com.example.desafio_android.data.local.database.ItemsDataBase
import com.example.desafio_android.data.local.repository.ReposLocalRepository
import com.example.desafio_android.data.local.repository.ReposLocalRepositoryImpl
import com.example.desafio_android.data.remote.api.GetRepositoriesService
import com.example.desafio_android.data.remote.repository.ReposRepository
import com.example.desafio_android.data.remote.repository.ReposRepositoryImpl
import com.example.desafio_android.data.remote.retrofit.ApiService
import com.example.desafio_android.data.remote.retrofit.HttpClient
import com.example.desafio_android.data.remote.source.ReposDataSource
import com.example.desafio_android.data.remote.source.ReposDataSourceImpl
import com.example.desafio_android.domain.usecase.GetReposUseCase
import com.example.desafio_android.presentation.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataBaseModule = module {
    single { ItemsDataBase.createDatabase(androidContext()) }

    single { get<ItemsDataBase>().itemsDao() }
}

val dataModule = module {
    factory {
        HttpClient(retrofit = ApiService.initRetrofit())
    }

    factory {
        get<HttpClient>().create(
            service = GetRepositoriesService::class.java
        )
    }

    factory<ReposDataSource> {
        ReposDataSourceImpl(service = get())
    }

    factory<ReposRepository> {
        ReposRepositoryImpl(dataSource = get())
    }

    factory<ReposLocalRepository> {
        ReposLocalRepositoryImpl(itemsDao = get())
    }
}

val domainModule = module {
    factory {
        GetReposUseCase(reposRepository = get())
    }
}

val presentationModule = module {
    viewModel {
        MainViewModel(useCase = get(), itemsLocalRepo = get())
    }
}