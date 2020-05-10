package com.test.data.service

import com.test.model.PhotoRes
import com.test.model.Post
import com.test.model.PostRes
import retrofit2.http.GET

interface JsonPlaceholderService {
    @GET("posts")
    suspend fun getPosts(): PostRes

    @GET("photos")
    suspend fun getPhotos(): PhotoRes
}