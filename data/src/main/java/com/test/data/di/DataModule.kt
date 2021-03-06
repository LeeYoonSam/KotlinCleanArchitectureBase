package com.test.data.di

import com.test.data.photo.*
import com.test.data.post.DefaultPostRepository
import com.test.data.post.PostDataSource
import com.test.data.post.PostRepository
import com.test.data.post.RemotePostDataSource
import com.test.data.service.JsonPlaceholderService
import com.test.model.Photo
import com.test.model.mapper.ListMapper
import com.test.model.mapper.ListMapperImpl
import com.test.model.mapper.Mapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {
    @Provides
    @Singleton
    fun providePostRemoteDataSource(service: JsonPlaceholderService): PostDataSource {
        return RemotePostDataSource(service)
    }

    @Provides
    @Singleton
    fun providePostRepository(postRemoteDataSource: RemotePostDataSource): PostRepository {
        return DefaultPostRepository(postRemoteDataSource)
    }

    @Provides
    @Singleton
    fun provideRemotePhotoDataSource(service: JsonPlaceholderService): PhotoDataSource {
        return RemotePhotoDataSource(service)
    }

    @Provides
    @Singleton
    fun providePhotoRepository(remotePhotoDataSource: RemotePhotoDataSource): PhotoRepository {
        return DefaultPhotoRepository(remotePhotoDataSource)
    }
}