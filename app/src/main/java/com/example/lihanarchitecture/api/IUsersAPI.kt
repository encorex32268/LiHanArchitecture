package com.example.lihanarchitecture.api

import com.example.lihanarchitecture.model.User
import retrofit2.Call
import retrofit2.http.GET

interface IUsersAPI {

    @GET("/users")
    fun getUsers() : Call<ArrayList<User>>
}