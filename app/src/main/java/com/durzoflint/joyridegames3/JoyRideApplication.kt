package com.durzoflint.joyridegames3

import android.app.Application
import com.durzoflint.joyridegames3.data.APIInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JoyRideApplication : Application() {
    private lateinit var retrofit: Retrofit
    private lateinit var apiService: APIInterface

    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        retrofit = Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(APIInterface::class.java)
    }

    fun getRetrofit(): Retrofit {
        return retrofit
    }

    fun getAPIInterface(): APIInterface {
        return apiService
    }
}