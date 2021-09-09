package com.durzoflint.joyridegames3.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.durzoflint.joyridegames3.R
import com.durzoflint.joyridegames3.data.users.UserResponse
import com.durzoflint.joyridegames3.data.users.Users


class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var userAdapter: UserAdapter
    private var users: ArrayList<Users> = arrayListOf()
    private lateinit var userRV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initObjs()
        getUsers()
    }

    private fun initObjs() {
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        userRV = findViewById(R.id.user_recycler_view)
        userAdapter = UserAdapter(this, users)
        userRV.adapter = userAdapter
    }

    private fun getUsers() {
        mainViewModel.getUser()
            .observe(this) {
                it?.let { usersResponse: UserResponse ->
                    if (!usersResponse.getErrorMessage().isEmpty()) {
                        Toast.makeText(this, "Error while getting Users", Toast.LENGTH_LONG).show()
                    } else {
                        setRecyclerViewAdapter(usersResponse.data)
                    }
                }
            }
    }

    private fun setRecyclerViewAdapter(newUsers: List<Users>) {
        users.clear()
        users.addAll(newUsers)
        userAdapter.notifyDataSetChanged()
    }
}