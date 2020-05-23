package com.test.data.photo

import com.test.data.service.JsonPlaceholderService
import com.test.model.Photo
import com.test.model.Result
import java.lang.RuntimeException
import javax.inject.Inject

interface PhotoDataSource {
    suspend fun getPhotos(): Result<List<Photo>>
}

class RemotePhotoDataSource @Inject constructor(private val service: JsonPlaceholderService): PhotoDataSource {

    override suspend fun getPhotos(): Result<List<Photo>> {
        val res = service.getPhotos()
        if(res.isSuccessful) {
            return Result.Success(res.body() ?: emptyList())
        }

        return Result.Error(RuntimeException("Network Error"))
    }
}