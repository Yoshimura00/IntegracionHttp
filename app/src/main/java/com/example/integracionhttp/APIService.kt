package com.example.integracionhttp

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
@GET
suspend fun getUsers(@Url url:String):Response<User>
}