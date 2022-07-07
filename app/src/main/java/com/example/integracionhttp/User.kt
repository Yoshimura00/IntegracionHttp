package com.example.integracionhttp

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("name") var nombre: String,
    @SerializedName("age")var edad: Int
    )
