package com.durzoflint.joyridegames3.ui

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.durzoflint.joyridegames3.JoyRideApplication
import com.durzoflint.joyridegames3.data.APIInterface
import com.durzoflint.joyridegames3.data.users.UserRepository
import com.durzoflint.joyridegames3.data.users.UserResponse
import retrofit2.Retrofit

class MainViewModel(context: Context) : ViewModel() {
    val context: Context
    var retrofitObj: Retrofit
    val repository: UserRepository
    val apiInterface: APIInterface
    var pageNumber = 1

    init {
        this.context = context
        retrofitObj = (context as JoyRideApplication).getRetrofit()
        apiInterface = context.getAPIInterface()

        repository = UserRepository(retrofitObj, apiInterface)
    }

    fun getUser(): MutableLiveData<UserResponse?> {
        return repository.getUsers(pageNumber)
    }
}