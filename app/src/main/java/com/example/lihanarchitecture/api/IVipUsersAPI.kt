package com.example.lihanarchitecture.api

import com.example.lihanarchitecture.model.VipUser
import retrofit2.Call
import retrofit2.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface IVipUsersAPI {

    companion object{
        private val SERVERURL = "https://34a75f4d-d83a-44e8-81a2-a1f3161df64b.mock.pstmn.io/"

        private val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(SERVERURL)
            .build()

        val api = retrofit.create(IVipUsersAPI::class.java)
    }




    @GET("/vipusers")
    fun getVipUsers(@Query("page") page:Int) : Call<ArrayList<VipUser>>
}