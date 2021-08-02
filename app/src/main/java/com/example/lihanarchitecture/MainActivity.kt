package com.example.lihanarchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lihanarchitecture.databinding.ActivityMainBinding
import com.example.lihanarchitecture.view.UserAdapter
import com.example.lihanarchitecture.viewmodel.UserViewModel
import retrofit2.*

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: UserViewModel
    private lateinit var mAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding.apply {
            userRecyclerView.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@MainActivity)
                mAdapter = UserAdapter(arrayListOf())
                adapter = mAdapter
            }
        }

        viewModel = ViewModelProvider.AndroidViewModelFactory(application).create(UserViewModel::class.java)
        viewModel.getUserList().observe(this@MainActivity,{
            mAdapter.apply {
                userList = it
                notifyDataSetChanged()
            }
        })

    }

    
}