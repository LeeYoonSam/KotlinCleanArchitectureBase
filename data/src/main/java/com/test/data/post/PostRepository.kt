package com.test.data.post

import com.test.model.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
}

class DefaultPostRepository(private val postRemoteDataSource: RemotePostDataSource): PostRepository {
    override suspend fun getPosts(): List<Post> {
        return postRemoteDataSource.getPosts()
    }
}