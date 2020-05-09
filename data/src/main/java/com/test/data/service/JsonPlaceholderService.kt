package com.test.data.service

import com.test.model.Post
import retrofit2.http.GET

interface JsonPlaceholderService {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}