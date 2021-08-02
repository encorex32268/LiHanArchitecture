package com.example.lihanarchitecture

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.lihanarchitecture.databinding.ItemUserBinding

class UserViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    private val binding = ItemUserBinding.bind(itemView)

    fun bindTo(user : User){
        binding.apply {
            userEmail.text = user.email
            userName.text = user.name
        }
    }



}