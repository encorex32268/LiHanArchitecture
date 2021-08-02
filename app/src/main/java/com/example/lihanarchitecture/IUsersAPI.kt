package com.example.lihanarchitecture

import retrofit2.Call
import retrofit2.http.GET

interface IUsersAPI {

    @GET("/users")
    fun getUsers() : Call<ArrayList<User>>
}