package com.durzoflint.joyridegames3.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.durzoflint.joyridegames3.R
import com.durzoflint.joyridegames3.data.users.Users

class UserAdapter(context: Context, users: List<Users>) : RecyclerView.Adapter<UserViewHolder>() {
    private var users: List<Users>
    private var context: Context

    init {
        this.users = users
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val rootView = LayoutInflater.from(context).inflate(R.layout.view_user, parent, false)
        return UserViewHolder(context, rootView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        Glide.with(context).load(users[position].imageUrl).into(holder.image)
        holder.name.text = "${users[position].firstName} ${users[position].lastName}"
        holder.email.text = users[position].email
    }

    override fun getItemCount(): Int {
        return users.size
    }
}