package com.test.data.photo

import com.test.model.Photo
import com.test.model.Result

interface PhotoRepository {
    suspend fun getPhotos(): Result<List<Photo>>
}

class DefaultPhotoRepository(
    private val remotePhotoDataSource: RemotePhotoDataSource
): PhotoRepository {

    override suspend fun getPhotos(): Result<List<Photo>> {
        return remotePhotoDataSource.getPhotos()
    }

//    private fun mapPhoto(networkPhotoList: List<Photo>): List<Photo> {
//        return networkPhotoList.map {
//            photoDataMapper.map(DataPhoto(it))
//        }
//    }
}

// A cluster of DTOs to be mapped into a Product
data class DataPhoto(
    val networkPhoto: Photo
)
