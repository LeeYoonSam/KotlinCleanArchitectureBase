package com.test.data.photo

import com.test.model.Photo

interface PhotoRepository {
    suspend fun getPhotos(): List<Photo>
}

class DefaultPhotoRepository(private val remotePhotoDataSource: RemotePhotoDataSource): PhotoRepository {
    override suspend fun getPhotos(): List<Photo> {
        return remotePhotoDataSource.getPhotos()
    }
}