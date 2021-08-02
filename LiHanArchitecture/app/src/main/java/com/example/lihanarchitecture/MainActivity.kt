package com.example.lihanarchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import retrofit2.*

class MainActivity : AppCompatActivity() {

    private val SERVERURL = "https://34a75f4d-d83a-44e8-81a2-a1f3161df64b.mock.pstmn.io/"
    private val TAG = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        getUsers()

    }

    private fun getUsers() {
        val retrofit =
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVERURL)
                .build()
        val userAPI = retrofit.create(IUsersAPI::class.java)
        val call = userAPI.getUsers()
        call.enqueue(object : Callback<ArrayList<User>>{
            override fun onResponse(
                call: Call<ArrayList<User>>,
                response: Response<ArrayList<User>>
            ) {
                val body = response.body()
                body?.let {
                    it.forEach {
                    Log.d(TAG, "onResponse: ${it.toString()}")
                } 
                }
            }

            override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                Log.d(TAG, "onFailure: ")
            }

        })
    }
}