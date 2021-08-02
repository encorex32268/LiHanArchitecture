package com.example.lihanarchitecture.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lihanarchitecture.R
import com.example.lihanarchitecture.model.User

class UserAdapter(var userList : ArrayList<User>) : RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindTo(userList[position])
        holder.itemView.tag = position
    }

    override fun getItemCount() = userList.size
}