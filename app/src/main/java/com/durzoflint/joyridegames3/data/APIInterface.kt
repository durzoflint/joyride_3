package com.durzoflint.joyridegames3.data

import com.durzoflint.joyridegames3.data.users.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    @GET("users")
    fun getUser(@Query("page") pageNumber: Int): Call<UserResponse>
}