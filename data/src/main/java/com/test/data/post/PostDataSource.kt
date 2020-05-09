package com.test.data.post

import com.test.data.service.JsonPlaceholderService
import com.test.model.Post
import javax.inject.Inject

interface PostDataSource {
    suspend fun getPosts(): List<Post>
}

class RemotePostDataSource @Inject constructor(private val service: JsonPlaceholderService): PostDataSource {
    override suspend fun getPosts(): List<Post> {
        return service.getPosts()
    }
}