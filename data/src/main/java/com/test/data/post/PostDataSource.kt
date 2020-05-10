package com.test.data.post

import com.test.data.service.JsonPlaceholderService
import com.test.model.Post
import java.lang.RuntimeException
import javax.inject.Inject

interface PostDataSource {
    suspend fun getPosts(): List<Post>
}

class RemotePostDataSource @Inject constructor(private val service: JsonPlaceholderService): PostDataSource {
    override suspend fun getPosts(): List<Post> {
        val res = service.getPosts()
        if(res.isSuccessful) {
            return res.body() ?: emptyList()
        }

        throw RuntimeException("Network Error")
    }
}