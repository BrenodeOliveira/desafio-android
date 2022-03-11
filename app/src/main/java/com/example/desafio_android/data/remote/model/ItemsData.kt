package com.example.desafio_android.data.remote.model

import com.google.gson.annotations.SerializedName

data class ItemsData(
    @SerializedName("items") val items: List<RepoData>?,
)


