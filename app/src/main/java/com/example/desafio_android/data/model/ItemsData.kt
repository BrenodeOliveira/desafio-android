package com.example.desafio_android.data.model

import com.google.gson.annotations.SerializedName

data class ItemsData(
    @SerializedName("items") val name: List<RepoData>?,
)