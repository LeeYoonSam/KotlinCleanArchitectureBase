package com.test.model

import com.google.gson.annotations.SerializedName
import retrofit2.Response

data class Photo(
    @SerializedName("albumId")
    val albumId: Int,

    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String
)

typealias PhotoRes = Response<List<Photo>>