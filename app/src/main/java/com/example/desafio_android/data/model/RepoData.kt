package com.example.desafio_android.data.model

import com.google.gson.annotations.SerializedName

data class RepoData(
    @SerializedName("name") val name: String?,
    @SerializedName("forks_count") val forks: Int?,
    @SerializedName("stargazers_count") val stars: Int?,
    @SerializedName("owner") val user: List<UserData>?,
)