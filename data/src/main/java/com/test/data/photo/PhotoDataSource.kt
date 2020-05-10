package com.test.data.photo

import com.test.data.service.JsonPlaceholderService
import com.test.model.Photo
import com.test.model.Post
import java.lang.RuntimeException
import javax.inject.Inject

interface PhotoDataSource {
    suspend fun getPhotos(): List<Photo>
}

class RemotePhotoDataSource @Inject constructor(private val service: JsonPlaceholderService): PhotoDataSource {
    override suspend fun getPhotos(): List<Photo> {
        val res = service.getPhotos()
        if(res.isSuccessful) {
            return res.body() ?: emptyList()
        }

        throw RuntimeException("Network Error")
    }
}