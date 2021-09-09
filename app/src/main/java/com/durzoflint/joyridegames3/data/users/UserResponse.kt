package com.durzoflint.joyridegames3.data.users

import com.google.gson.annotations.SerializedName

class UserResponse(
    @SerializedName("page") val page: Int = 0,
    @SerializedName("per_page") val perPage: Int = 0,
    @SerializedName("total") val total: Int = 0,
    @SerializedName("total_pages") val totalPages: Int = 0,
    @SerializedName("data") val data: List<Users> = listOf(),

    private var errorMessage: String = ""
) {
    fun setErrorMessage(message: String) {
        errorMessage = message
    }

    fun getErrorMessage(): String {
        return errorMessage
    }
}