package com.test.model

import com.google.gson.annotations.SerializedName
import retrofit2.Response

data class Post(
    @SerializedName("userId")
    val userId: Int,

    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("body")
    val body: String
)

typealias PostRes = Response<List<Post>>