package com.example.exampleforretrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleforretrofit.R
import com.example.exampleforretrofit.model.user


class UserAdapter(private val userList: List<user>):
        RecyclerView.Adapter<UserAdapter.userViewHolder>(){

    class userViewHolder(view: View):RecyclerView.ViewHolder(view){
                val nameTextView:TextView=view.findViewById(R.id.tvName)
                val emailTextView:TextView=view.findViewById(R.id.tvEmail)
                val phoneTextView:TextView=view.findViewById(R.id.tvPhone)

            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.userViewHolder {
        TODO("Not yet implemented")
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)
        return userViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: UserAdapter,
        position: Int,

    ) {

     val user=userList[position]
        holder.nameTextView.text=user.name
        holder.emailTextView.text=user.email
        holder.phoneTextView.text=user.phone
    }

    override fun getItemCount(): Int =userList.size
        }