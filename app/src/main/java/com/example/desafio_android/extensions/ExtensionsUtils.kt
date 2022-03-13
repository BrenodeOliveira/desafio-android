package com.example.desafio_android.extensions

import com.example.desafio_android.data.remote.model.ItemsData
import com.example.desafio_android.data.remote.model.RepoData
import com.example.desafio_android.data.remote.model.UserData
import com.example.desafio_android.domain.model.ItemsModel
import com.example.desafio_android.domain.model.RepoModel
import com.example.desafio_android.domain.model.UserModel

fun UserData.toModel() : UserModel {
    return UserModel(
        this.photo.orEmpty(),
        this.login.orEmpty(),
    )
}

fun RepoData.toModel() : RepoModel {
    return RepoModel(
        this.name.orEmpty(),
        this.forks.toString(),
        this.stars.toString(),
        this.user?.toModel() ?: UserModel("",""),
        this.language.orEmpty()
    )
}

fun ItemsData.toModel() : ItemsModel {
    return ItemsModel(
        this.items?.map {
            it.toModel()
        } ?: listOf()
    )
}