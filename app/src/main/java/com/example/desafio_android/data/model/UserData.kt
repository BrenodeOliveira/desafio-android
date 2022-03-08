package com.example.desafio_android.data.model

import com.google.gson.annotations.SerializedName

data class UserData(
    @SerializedName("avatar_url") val photo: String?,
    @SerializedName("login") val name: String?,
)