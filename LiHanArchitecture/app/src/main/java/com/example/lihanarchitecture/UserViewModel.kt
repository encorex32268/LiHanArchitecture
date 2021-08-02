package com.example.lihanarchitecture

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.*

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val SERVERURL = "https://34a75f4d-d83a-44e8-81a2-a1f3161df64b.mock.pstmn.io/"
    private val TAG = UserViewModel::class.java.simpleName

    private var userList = MutableLiveData<ArrayList<User>>()
    init {
        getUsers()
    }

    fun getUserList() : LiveData<ArrayList<User>>{
        return userList
    }


    private fun getUsers() {
        val retrofit =
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVERURL)
                .build()
        val userAPI = retrofit.create(IUsersAPI::class.java)
        val call = userAPI.getUsers()
        call.enqueue(object : Callback<ArrayList<User>> {
            override fun onResponse(
                call: Call<ArrayList<User>>,
                response: Response<ArrayList<User>>
            ) {
                val body = response.body()
                body?.let {
                    userList.postValue(it)
                }
            }
            override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                Log.d(TAG, "onFailure: ")
            }

        })
    }
}