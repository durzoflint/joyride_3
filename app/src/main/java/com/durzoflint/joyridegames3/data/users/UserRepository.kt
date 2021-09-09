package com.durzoflint.joyridegames3.data.users

import androidx.lifecycle.MutableLiveData
import com.durzoflint.joyridegames3.data.APIInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class UserRepository(retrofitObj: Retrofit, apiInterface: APIInterface) {
    val apiInterface: APIInterface

    init {
        this.apiInterface = apiInterface
    }

    fun getUsers(pageNumber: Int = 1): MutableLiveData<UserResponse?> {
        val userResponse = MutableLiveData<UserResponse?>()

        val call = apiInterface.getUser(pageNumber)
        call.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                userResponse.value = response.body()
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                val apiResponse = UserResponse()
                apiResponse.setErrorMessage(t.localizedMessage)
                userResponse.value = apiResponse
            }
        })

        return userResponse
    }
}