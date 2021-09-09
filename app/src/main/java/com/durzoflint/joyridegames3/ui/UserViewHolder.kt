package com.durzoflint.joyridegames3.ui

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.durzoflint.joyridegames3.R

class UserViewHolder(context: Context, itemView: View) : ViewHolder(itemView) {
    var image: ImageView
    var name: TextView
    var email: TextView

    init {
        image = itemView.findViewById(R.id.image)
        name = itemView.findViewById(R.id.name)
        email = itemView.findViewById(R.id.email)
    }
}